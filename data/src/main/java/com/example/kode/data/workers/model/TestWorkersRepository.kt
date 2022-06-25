package com.example.kode.data.workers.model

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersEntity
import com.example.kode.domain.repository.WorkersRepository
import org.junit.Test

class TestWorkersRepository {

    @Test
    fun `get success mapped workers list`() {
        val testCacheDataSource = WorkersCacheDataSource<WorkersDataModel>()
        val testCloudDataSource = WorkersCloudDataSource<WorkersDataModel>()
        val mapper = Base.Mapper<WorkersDataModel, WorkersEntity>()
        val repository = WorkersRepositoryImpl<WorkersEntity>(
            testCacheDataSource,
            testCloudDataSource,
            mapper
        )

    }
}