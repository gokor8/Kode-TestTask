package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.WorkersRepositoryImpl
import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSource
import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import com.example.kode.domain.entity.workers.WorkersEntity
import org.junit.Assert
import org.junit.Test
import java.io.IOException

class TestWorkersRepository {

    private val dataToEntityMapper = TestWorkersDataToEntityMapper()

    @Test
    fun `get success from cloud and save`() {
        val command = TestCommands.Success()
        val expected = WorkersEntity.SuccessEntity(
            "test",
            "test",
            "test",
            "test"
        )
        val expectedCacheData = WorkersDataModel.Success(
            "test",
            "test",
            "test",
            "test"
        )

        val testCacheDataSource = TestWorkersCacheDataSource()
        val testCloudDataSource = TestWorkersCloudDataSource(command)

        val repository = WorkersRepositoryImpl(
            testCloudDataSource,
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
    fun `get saved data from cache`() {
        val command = TestCommands.NoConnection()

        val testCacheDataSource = TestWorkersSavedCacheDataSource()
        val testCloudDataSource = TestWorkersCloudDataSource(command)
        val repository = WorkersRepositoryImpl(
            testCloudDataSource,
            testCacheDataSource,
            dataToEntityMapper
        )

        // Проверка сохраненных данных из кэша, если нету интернета
        val actual = repository.getWorkers()
        val expected = WorkersEntity.SuccessEntity(
            "saved",
            "saved",
            "saved",
            "saved"
        )
        Assert.assertEquals(expected, actual)
    }

    @Test(expected = TestNoCacheException::class)
    fun `get empty cache exception`() {
        val command = TestCommands.NoConnection()

        val testCacheDataSource = TestWorkersCacheDataSource()
        val testCloudDataSource = TestWorkersCloudDataSource(command)
        val repository = WorkersRepositoryImpl(
            testCloudDataSource,
            testCacheDataSource,
            dataToEntityMapper
        )

        val actual = repository.getWorkers()
        val expected = WorkersEntity.SuccessEntity(
            "test",
            "test",
            "test",
            "test"
        )
        Assert.assertEquals(expected, actual)
    }

    sealed class TestCommands {
        class Success : TestCommands()
        class NoConnection : TestCommands()
        class Fail : TestCommands()
        class Exception : TestCommands()
    }

    // DataSources
    class TestWorkersCloudDataSource(private val testCommands: TestCommands) :
        WorkersCloudDataSource<WorkersDataModel> {

        override fun get(): WorkersDataModel = when (testCommands) {
            is TestCommands.Success -> WorkersDataModel.Success(
                "test",
                "test",
                "test",
                "test"
            )
            is TestCommands.NoConnection -> throw NoConnectionException()
            is TestCommands.Fail -> throw TestBadRequestException()
            is TestCommands.Exception -> throw IOException()
        }
    }

    class TestWorkersCacheDataSource() :
        WorkersCacheDataSource<WorkersDataModel, WorkersDataModel> {

        private var listDataModels: WorkersDataModel.Success? = null

        override fun get() = listDataModels ?: throw TestNoCacheException()

        override fun save(model: WorkersDataModel) {
            if (model is WorkersDataModel.Success) listDataModels = model
        }
    }

    class TestWorkersSavedCacheDataSource() :
        WorkersCacheDataSource<WorkersDataModel, WorkersDataModel> {

        private var listDataModels: WorkersDataModel.Success = WorkersDataModel.Success(
            "saved",
            "saved",
            "saved",
            "saved"
        )

        override fun get() = listDataModels

        override fun save(model: WorkersDataModel) {}
    }

    // Custom Exceptions
    class TestBadRequestException : IOException()
    class TestNoCacheException : IOException()


    // Mappers
    class TestWorkersDataToEntityMapper :
        Base.Mapper<WorkersDataModel, WorkersEntity> {

        override fun map(model: WorkersDataModel): WorkersEntity =
            when (model) {
                is WorkersDataModel.Success -> with(model) {
                    WorkersEntity.SuccessEntity(
                        name, lastName, userTag, position
                    )
                }
            }
    }
}