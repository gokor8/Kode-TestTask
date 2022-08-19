package com.example.kode.test_task.di.modules.data.cache

import com.example.kode.data.datasource.workers.cache.RealmWorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import dagger.Binds
import dagger.Module

@Module(includes = [BCacheDataSourceMapperModule::class, PCacheModule::class])
interface BCacheDataSourceModule {

    @Binds
    fun bindRealmCacheDataSource(cache: RealmWorkersCacheDataSource<WorkersInfoStateDataModel, RealmWorkerModel>)
            : WorkersCacheDataSource<WorkersInfoStateDataModel>
}
