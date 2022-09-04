package com.example.kode.test_task.di.modules.data.cache.realm

import com.example.kode.data.datasource.workers.cache.realm.RealmWorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.realm.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.test_task.di.modules.data.cache.room.PCacheRoomModule
import dagger.Binds
import dagger.Module

@Module(includes = [BRealmCacheDataSourceMapperModule::class, PCacheRoomModule::class])
interface BRealmCacheDataSourceModule {

    @Binds
    fun bindRealmCacheDataSource(cache: RealmWorkersCacheDataSource<WorkersInfoStateDataModel, RealmWorkerModel>)
            : WorkersCacheDataSource<WorkersInfoStateDataModel>
}
