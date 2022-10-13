package com.example.kode.test_task.di.modules.data.cache.room

import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.room.RoomWorkerCacheDataSource
import com.example.kode.data.datasource.workers.cache.room.RoomWorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.room.WorkerCacheDataSource
import com.example.kode.data.repository.worker.models.WorkerInputDataModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import dagger.Binds
import dagger.Module

@Module(includes = [BRoomCacheDataSourceMapperModule::class, PCacheRoomModule::class])
interface BRoomCacheDataSourceModule {

    @Binds
    fun bindRoomWorkersCacheDataSource(roomWorkersCacheDataSource: RoomWorkersCacheDataSource<WorkersInfoStateDataModel>)
            : WorkersCacheDataSource<WorkersInfoStateDataModel>

    @Binds
    fun bindRoomWorkerCacheDataSource(roomWorkerCacheDataSource: RoomWorkerCacheDataSource<WorkerInputDataModel, WorkerInfoDataModel>)
            : WorkerCacheDataSource<WorkerInputDataModel, WorkerInfoDataModel>
}