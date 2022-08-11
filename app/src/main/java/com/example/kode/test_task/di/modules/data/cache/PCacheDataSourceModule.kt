package com.example.kode.test_task.di.modules.data.cache

import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import dagger.Module
import dagger.Provides

@Module
class PCacheDataSourceModule {

    @Provides
    fun provideRealmDataSource(): WorkersCacheDataSource<WorkersInfoStateDataModel> = object : WorkersCacheDataSource<WorkersInfoStateDataModel> {
        override suspend fun get(): WorkersInfoStateDataModel {
            TODO("Not yet implemented")
        }

        override suspend fun save(model: WorkersInfoStateDataModel) {
            TODO("Not yet implemented")
        }

    }

}