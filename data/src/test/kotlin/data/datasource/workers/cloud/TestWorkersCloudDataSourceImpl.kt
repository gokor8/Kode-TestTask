package data.datasource.workers.cloud

import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSourceImpl
import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.domain.core.Base
import data.core.TestModel
import data.core.TestReturnedModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class TestWorkersCloudDataSourceImpl {

    private val apiService: TestWorkersService = TestWorkersService()
    private val testModelToTestReturnedModelMapper = TestModelToTestReturnedModelMapper()

    @Test
    fun `test get success data from api`() = runBlocking {
        val workersCloudDataSource = WorkersCloudDataSourceImpl(
            apiService,
            testModelToTestReturnedModelMapper
        )

        val expected = TestReturnedModel("mapped cloud test")
        val actual = workersCloudDataSource.get()

        Assert.assertEquals(expected, actual)
    }

    class TestWorkersService : WorkersService<TestModel> {
        override suspend fun getWorkers(): TestModel = TestModel(
            "cloud test"
        )
    }

    class TestModelToTestReturnedModelMapper : Base.Mapper<TestModel, TestReturnedModel> {

        override fun map(model: TestModel): TestReturnedModel =
            TestReturnedModel(
                "mapped ${model.name}"
            )
    }
}