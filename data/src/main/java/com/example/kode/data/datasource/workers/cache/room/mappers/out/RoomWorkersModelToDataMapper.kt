package com.example.kode.data.datasource.workers.cache.room.mappers.out

import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

class RoomWorkersModelToDataMapper @Inject constructor() : Base.Mapper<RoomWorkerModel, WorkerInfoDataModel> {

     override fun map(model: RoomWorkerModel): WorkerInfoDataModel = with(model) {
        WorkerInfoDataModel(
            id,
            avatarUrl ?: "",
            name ?: "",
            lastName ?: "",
            userTag ?: "",
            department ?: "",
            position ?: "",
            listOf(birthday ?: ""),
            phone ?: ""
        )
    }
}