package data.repository.workers

import com.example.kode.data.datasource.core.DataSourceModel
import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSource
import com.example.kode.data.repository.workers.WorkersRepositoryImpl
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import java.io.IOException

class TestWorkersRepository {

    private val dataToEntityMapper = TestRepositoryModelToEntityModelMapper()

    @Test
    fun `test success from cloud and save`() = runBlocking {
        val command = TestCommands.Success()
        val expected = TestEntityModel(
            "mapped cloud 1"
        )
        val expectedCacheData = TestRepositoryModel(
            "cloud 1"
        )

        val testCacheDataSource = TestWorkersCacheDataSource()

        val repository = WorkersRepositoryImpl(
            TestWorkersCloudDataSource(command),
            testCacheDataSource,
            dataToEntityMapper
        )

        // Проверка корректнных данных из сети
        val actual = repository.getWorkers()
        Assert.assertEquals(expected, actual)

        // Проверка что кэш не пустой, и данные записались
        val actualCacheData = testCacheDataSource.get()
        Assert.assertEquals(expectedCacheData, actualCacheData)
    }

    @Test
    fun `test saved data from cache`() = runBlocking {
        val command = TestCommands.NoConnection()
        val savedCacheModel = TestRepositoryModel("cached 1")

        val repository = WorkersRepositoryImpl(
            TestWorkersCloudDataSource(command),
            TestWorkersCacheDataSource(savedCacheModel),
            dataToEntityMapper
        )

        // Проверка сохраненных данных из кэша, если нету интернета
        val actual = repository.getWorkers()
        val expected = TestEntityModel(
            "mapped cached 1"
        )
        Assert.assertEquals(expected, actual)
    }

    @Test(expected = TestNoCacheException::class)
    fun `test empty cache exception`(): Unit = runBlocking {
        val command = TestCommands.NoConnection()

        val repository = WorkersRepositoryImpl(
            TestWorkersCloudDataSource(command),
            TestWorkersCacheDataSource(),
            dataToEntityMapper
        )

        repository.getWorkers()
    }

    @Test(expected = GenericException::class)
    fun `test generic exception`(): Unit = runBlocking {
        val command = TestCommands.Exception()

        val repository = WorkersRepositoryImpl(
            TestWorkersCloudDataSource(command),
            TestWorkersCacheDataSource(),
            dataToEntityMapper
        )

        repository.getWorkers()
    }


    // TEST REALIZATIONS

    data class TestRepositoryModel(val name: String) : DataSourceModel<TestRepositoryModel> {
        override fun <I : Base.Mapper<TestRepositoryModel, R>, R> map(model: I) = model.map(this)
    }

    data class TestEntityModel(val name: String) : UseCaseModel<TestEntityModel> {
        override fun <I : Base.Mapper<TestEntityModel, R>, R> map(model: I) = model.map(this)
    }

    sealed class TestCommands {
        class Success : TestCommands()
        class NoConnection : TestCommands()
        class Exception : TestCommands()
    }

    // DataSources
    class TestWorkersCloudDataSource(private val testCommands: TestCommands) :
        WorkersCloudDataSource<TestRepositoryModel> {

        override suspend fun get(): TestRepositoryModel = when (testCommands) {
            is TestCommands.Success -> TestRepositoryModel(
                "cloud 1",
            )
            is TestCommands.NoConnection -> throw NoConnectionException()
            is TestCommands.Exception -> throw GenericException()
        }
    }

    class TestWorkersCacheDataSource(
        cacheDataModel: TestRepositoryModel? = null
    ) :
        WorkersCacheDataSource<TestRepositoryModel> {

        private var listDataModels: TestRepositoryModel? = cacheDataModel

        override suspend fun get() = listDataModels ?: throw TestNoCacheException()

        override suspend fun save(model: TestRepositoryModel) {
            listDataModels = model
        }
    }

    // Custom UseCaseExceptions
    class TestNoCacheException : IOException()
    class GenericException : IOException()

    // Mappers
    class TestRepositoryModelToEntityModelMapper :
        Base.Mapper<TestRepositoryModel, TestEntityModel> {

        override fun map(model: TestRepositoryModel): TestEntityModel =
            TestEntityModel(
                "mapped ${model.name}"
            )
    }
}