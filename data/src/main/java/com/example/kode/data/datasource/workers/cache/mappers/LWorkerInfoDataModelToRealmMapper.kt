package com.example.kode.data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base

class LWorkerInfoDataModelToRealmMapper(
    private val mapper: Base.Mapper<WorkerInfoDataModel, RealmWorkerModel>
) :
    Base.Mapper<List<WorkerInfoDataModel>, List<RealmWorkerModel>> {
    override fun map(model: List<WorkerInfoDataModel>): List<RealmWorkerModel> =
        model.map { it.map(mapper) }
}