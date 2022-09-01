package com.example.kode.data.datasource.workers.cache.room.mappers.out

import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

class LRoomToWorkersCacheDataStateMapper @Inject constructor(
    private val modelMapper: Base.Mapper<RoomWorkerModel, WorkerInfoDataModel>
) : Base.Mapper<MutableList<RoomWorkerModel>, WorkersInfoStateDataModel> {

    override fun map(model: MutableList<RoomWorkerModel>) =
        WorkersInfoStateDataModel.Cache(
            model.map {
                it.map(modelMapper)
            }
        )
}