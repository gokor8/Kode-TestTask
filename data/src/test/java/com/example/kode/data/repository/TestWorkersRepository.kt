package com.example.kode.data.repository

import com.example.kode.data.workers.cloud.WorkersCloudDataSource
import com.example.kode.data.workers.cloud.WorkersResponse
import com.example.kode.data.workers.model.WorkersDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersEntity
import org.junit.Test
import java.io.IOException

class TestWorkersRepository {

    @Test
    fun `get success mapped workers list`() {
        val command = TestCommands.Success()

        val testCacheDataSource = WorkersCacheDataSource<WorkersDataModel>()
        val testCloudDataSource = TestWorkersCloudDataSource(command)
        val mapper = Base.Mapper<WorkersDataModel, WorkersEntity>()
        val repository = WorkersRepositoryImpl<WorkersEntity>(
            testCacheDataSource,
            testCloudDataSource,
            mapper
        )

    }

    sealed class TestCommands {
        class Success() : TestCommands()
        class Fail() : TestCommands()
        class Exception() : TestCommands()
    }

    class TestWorkersCloudDataSource(val testCommands: TestCommands) : WorkersCloudDataSource {

        override fun getWorkers(): WorkersResponse = when(testCommands) {
            is TestCommands.Success -> WorkersResponse("test",
                "test",
                "test",
                "test",
                "test",
                "test",
                "test",
                listOf("test"),
                "test"
                )
            is TestCommands.Fail -> throw TestBadRequest()
            is TestCommands.Exception -> throw IOException()
        }
    }

    class TestBadRequest : IOException()
}