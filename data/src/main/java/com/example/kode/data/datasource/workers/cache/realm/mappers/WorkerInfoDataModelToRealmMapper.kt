package com.example.kode.data.datasource.workers.cache.realm.mappers

import com.example.kode.data.datasource.workers.cache.realm.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

class WorkerInfoDataModelToRealmMapper @Inject constructor() :
    Base.Mapper<WorkerInfoDataModel, RealmWorkerModel> {

    override fun map(model: WorkerInfoDataModel): RealmWorkerModel = with(model) {
        RealmWorkerModel(
            id,
            avatarUrl,
            firstName,
            lastName,
            userTag,
            department,
            position,
            birthday.first(),
            phone
        )
    }
}