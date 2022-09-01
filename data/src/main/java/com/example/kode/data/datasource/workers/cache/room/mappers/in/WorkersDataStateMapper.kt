package com.example.kode.data.datasource.workers.cache.room.mappers.`in`

import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import java.io.IOException
import javax.inject.Inject

class WorkersDataStateMapper @Inject constructor(
    private val workersCloudMapper: Base.Mapper<WorkersInfoStateDataModel.Cloud, MutableList<RoomWorkerModel>>
) : Base.Mapper<WorkersInfoStateDataModel, MutableList<RoomWorkerModel>> {

    override fun map(model: WorkersInfoStateDataModel): MutableList<RoomWorkerModel> = when (model) {
        is WorkersInfoStateDataModel.Cloud -> model.let(workersCloudMapper::map)
        else ->
            throw IOException("You cant save another model, please expand this mapper")
    }

}