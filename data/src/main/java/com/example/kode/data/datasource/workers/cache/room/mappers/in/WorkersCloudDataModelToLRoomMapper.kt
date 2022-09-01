package com.example.kode.data.datasource.workers.cache.room.mappers.`in`

import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

class WorkersCloudDataModelToLRoomMapper @Inject constructor(
    private val modelMapper: Base.Mapper<WorkerInfoDataModel, RoomWorkerModel>
) : Base.Mapper<WorkersInfoStateDataModel.Cloud, MutableList<RoomWorkerModel>> {

    override fun map(model: WorkersInfoStateDataModel.Cloud) =
        model.workers.map { it.map(modelMapper) }.toMutableList()

}