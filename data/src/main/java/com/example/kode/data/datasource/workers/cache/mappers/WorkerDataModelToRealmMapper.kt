package com.example.kode.data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base

class WorkerDataModelToRealmMapper : Base.Mapper<WorkerInfoDataModel.Success, RealmWorkerModel> {

    override fun map(model: WorkerInfoDataModel.Success): RealmWorkerModel = with(model) {
        RealmWorkerModel(
            0,
            id,
            avatarUrl,
            firstName,
            lastName,
            userTag,
            department,
            position,
            birthday,
            phone
        )
    }
}