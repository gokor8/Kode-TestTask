package com.example.kode.test_task.di.modules.data.cache

import com.example.kode.data.datasource.workers.cache.room.mappers.`in`.WorkerInfoDataModelToRoomMapper
import com.example.kode.data.datasource.workers.cache.room.mappers.`in`.WorkersCloudDataModelToLRoomMapper
import com.example.kode.data.datasource.workers.cache.room.mappers.`in`.WorkersDataStateMapper
import com.example.kode.data.datasource.workers.cache.room.mappers.out.LRoomToWorkersCacheDataStateMapper
import com.example.kode.data.datasource.workers.cache.room.mappers.out.RoomWorkersModelToDataMapper
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import dagger.Binds
import dagger.Module

@Module
interface BRoomCacheDataSourceMapperModule {

    @Binds
    fun bindWorkerInfoDataModelToRoomMapper(workerInfoDataModelToRoomMapper: WorkerInfoDataModelToRoomMapper)
            : Base.Mapper<WorkerInfoDataModel, RoomWorkerModel>

    @Binds
    fun bindWorkersCloudDataModelToLRoomMapper(workersCloudDataModelToLRoomMapper: WorkersCloudDataModelToLRoomMapper)
            : Base.Mapper<WorkersInfoStateDataModel.Cloud, MutableList<RoomWorkerModel>>

    @Binds
    fun bindWorkersDataStateMapper(workersDataStateMapper: WorkersDataStateMapper)
            : Base.Mapper<WorkersInfoStateDataModel, MutableList<RoomWorkerModel>>

    @Binds
    fun bindLRoomToWorkersCacheDataStateMapper(lRoomToWorkersCacheDataStateMapper: LRoomToWorkersCacheDataStateMapper)
            : Base.Mapper<MutableList<RoomWorkerModel>, WorkersInfoStateDataModel>

    @Binds
    fun bindRoomWorkersModelToDataMapper(roomWorkersModelToDataMapper: RoomWorkersModelToDataMapper)
            : Base.Mapper<RoomWorkerModel, WorkerInfoDataModel>
}