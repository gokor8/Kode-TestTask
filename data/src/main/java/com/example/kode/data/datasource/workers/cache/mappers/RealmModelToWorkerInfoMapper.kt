package com.example.kode.data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

class RealmModelToWorkerInfoMapper @Inject constructor() : Base.Mapper<RealmWorkerModel, WorkerInfoDataModel> {
    override fun map(model: RealmWorkerModel): WorkerInfoDataModel = with(model) {
        WorkerInfoDataModel(
            id,
            avatarUrl,
            name,
            lastName,
            userTag,
            department,
            position,
            listOf(birthday),
            phone
        )
    }
}