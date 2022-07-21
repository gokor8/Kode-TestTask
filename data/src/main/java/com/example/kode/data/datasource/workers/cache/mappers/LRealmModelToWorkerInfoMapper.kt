package com.example.kode.data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base

class LRealmModelToWorkerInfoMapper(
    private val mapper: Base.Mapper<RealmWorkerModel, WorkerInfoDataModel>
) : Base.Mapper<List<RealmWorkerModel>, List<WorkerInfoDataModel>> {

    override fun map(model: List<RealmWorkerModel>): List<WorkerInfoDataModel> =
        model.map { it.map(mapper) }
}