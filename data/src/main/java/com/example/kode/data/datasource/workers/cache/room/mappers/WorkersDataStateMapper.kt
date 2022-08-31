package com.example.kode.data.datasource.workers.cache.room.mappers

import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import java.io.IOException
import javax.inject.Inject

class WorkersDataStateMapper @Inject constructor(
    private val workersCloudMapper
    : Base.Mapper<List<WorkerInfoDataModel>, List<RoomWorkerModel>>
) : Base.Mapper<WorkersInfoStateDataModel, List<RoomWorkerModel>> {

    override fun map(model: WorkersInfoStateDataModel): List<RoomWorkerModel> = when (model) {
        is WorkersInfoStateDataModel.Cloud -> workersCloudMapper.map(model.workers)
        else -> throw IOException("You cant save another model, please expand this mapper")
    }

}