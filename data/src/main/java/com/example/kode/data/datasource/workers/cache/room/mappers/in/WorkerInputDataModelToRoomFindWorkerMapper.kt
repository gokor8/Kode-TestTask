package com.example.kode.data.datasource.workers.cache.room.mappers.`in`

import com.example.kode.data.datasource.workers.cache.room.models.RoomFindWorkerModel
import com.example.kode.data.repository.worker.models.WorkerInputDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

class WorkerInputDataModelToRoomFindWorkerMapper @Inject constructor() :
    Base.Mapper<WorkerInputDataModel, RoomFindWorkerModel> {
    override fun map(model: WorkerInputDataModel) = RoomFindWorkerModel(model.userId)
}