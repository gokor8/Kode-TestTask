package com.example.kode.data.datasource.workers.cloud

import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse
import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.core.Base
import org.junit.Assert
import org.junit.Test

class TestWorkersCloudDataSourceImpl {

    private val apiService: TestWorkersService = TestWorkersService()
    private val workersResponseToRepositoryMapper = WorkersResponseToRepositoryMapper()

    @Test
    fun `test get success data from api`() {
        val workersCloudDataSource = WorkersCloudDataSourceImpl<WorkersDataModel>(
            apiService,
            workersResponseToRepositoryMapper
        )

        val expected = WorkersDataModel.Success(
            "test",
            "test",
            "test",
            "test"
        )
        val actual = workersCloudDataSource.get()

        Assert.assertEquals(expected, actual)
    }

    class TestWorkersService : WorkersService {
        override fun getWorkers(): WorkersResponse = WorkersResponse(
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            listOf("test"),
            "test"
        )
    }

    class WorkersResponseToRepositoryMapper : Base.Mapper<WorkersResponse, WorkersDataModel> {

        override fun map(model: WorkersResponse): WorkersDataModel = with(model) {
            WorkersDataModel.Success(
                firstName, lastName, userTag, position
            )
        }
    }
}