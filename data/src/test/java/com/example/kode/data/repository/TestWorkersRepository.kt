package com.example.kode.data.repository

import com.example.kode.data.workers.WorkersSuccessDataToDomainMapper
import com.example.kode.data.workers.WorkersRepositoryImpl
import com.example.kode.data.workers.cache.WorkersCacheDataSource
import com.example.kode.data.workers.cloud.WorkersCloudDataSource
import com.example.kode.data.workers.model.WorkersDataModel
import com.example.kode.domain.entity.workers.WorkersEntity
import org.junit.Assert
import org.junit.Test
import java.io.IOException

class TestWorkersRepository {

    @Test
    fun `get success mapped workers list from cloud and save`() {
        val command = TestCommands.Success()

        val testCacheDataSource = TestWorkersCacheDataSource()
        val testCloudDataSource = TestWorkersCloudDataSource(command)
        val mapper = WorkersSuccessDataToDomainMapper()
        val repository = WorkersRepositoryImpl(
            testCloudDataSource,
            testCacheDataSource,
            mapper
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

    @Test
    fun `save and get success workers list from cache`() {
        val command = TestCommands.Success()

        val testCacheDataSource = TestWorkersCacheDataSource()
        val testCloudDataSource = TestWorkersCloudDataSource(command)
        val mapper = WorkersSuccessDataToDomainMapper()
        val repository = WorkersRepositoryImpl(
            testCloudDataSource,
            testCacheDataSource,
            mapper
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
        class Fail : TestCommands()
        class Exception : TestCommands()
    }

    class TestWorkersCloudDataSource(private val testCommands: TestCommands) :
        WorkersCloudDataSource<WorkersDataModel> {

        override fun get(): WorkersDataModel = when (testCommands) {
            is TestCommands.Success -> WorkersDataModel(
                "test",
                "test",
                "test",
                "test"
            )
            is TestCommands.Fail -> throw TestBadRequest()
            is TestCommands.Exception -> throw IOException()
        }
    }

    class TestWorkersCacheDataSource() : WorkersCacheDataSource<WorkersDataModel> {

        private var listDataModels: WorkersDataModel? = null

        override fun get(): WorkersDataModel = listDataModels ?: WorkersDataModel(
            "",
            "",
            "",
            "",
        )

        override fun save(model: WorkersDataModel) {
            listDataModels = model
        }
    }

    class TestBadRequest : IOException()
}