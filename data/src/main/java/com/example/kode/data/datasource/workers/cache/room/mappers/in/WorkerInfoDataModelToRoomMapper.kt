package com.example.kode.data.datasource.workers.cache.room.mappers.`in`

import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

class WorkerInfoDataModelToRoomMapper @Inject constructor() : Base.Mapper<WorkerInfoDataModel, RoomWorkerModel> {

    override fun map(model: WorkerInfoDataModel): RoomWorkerModel = with(model) {
        RoomWorkerModel(
            id = id,
            avatarUrl = avatarUrl,
            name = firstName,
            lastName = lastName,
            userTag = userTag,
            department = department,
            position = position,
            birthday = birthday.first(),
            phone = phone
        )
    }
}