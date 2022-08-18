package data.datasource.workers.cloud

import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSourceImpl
import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import data.core.TestModel
import data.core.TestReturnedModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import java.net.UnknownHostException

class TestWorkersCloudDataSourceImpl {

    private val testModelToTestReturnedModelMapper = TestModelToTestReturnedModelMapper()

    @Test
    fun `test get success data from api`() = runBlocking {
        val apiService = TestWorkersService(WorkersServiceState.SUCCESS)
        val workersCloudDataSource = WorkersCloudDataSourceImpl(
            apiService,
            testModelToTestReturnedModelMapper
        )

        val expected = TestReturnedModel("mapped cloud test")
        val actual = workersCloudDataSource.get()

        Assert.assertEquals(expected, actual)
    }

    @Test(expected = NoConnectionException::class)
    fun `test get exception from api`() = runBlocking {
        val apiService = TestWorkersService(WorkersServiceState.EXCEPTION)
        val workersCloudDataSource = WorkersCloudDataSourceImpl(
            apiService,
            testModelToTestReturnedModelMapper
        )

        val expected = TestReturnedModel("mapped cloud test")
        val actual = workersCloudDataSource.get()

        Assert.assertEquals(expected, actual)
    }

    // TEST REALIZATION

    enum class WorkersServiceState {
        SUCCESS,
        EXCEPTION
    }

    class TestWorkersService(private val state: WorkersServiceState) : WorkersService<TestModel> {
        override suspend fun getWorkers(): TestModel = when(state) {
            WorkersServiceState.SUCCESS -> TestModel("cloud test")
            WorkersServiceState.EXCEPTION -> throw UnknownHostException()
        }
    }

    class TestModelToTestReturnedModelMapper : Base.Mapper<TestModel, TestReturnedModel> {

        override fun map(model: TestModel): TestReturnedModel =
            TestReturnedModel(
                "mapped ${model.name}"
            )
    }
}