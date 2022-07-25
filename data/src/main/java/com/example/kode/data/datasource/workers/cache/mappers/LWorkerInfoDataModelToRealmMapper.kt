package com.example.kode.data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base

class LWorkerInfoDataModelToRealmMapper(
    private val mapper: Base.Mapper<WorkerInfoDataModel.Success, RealmWorkerModel>
) :
    Base.Mapper<List<WorkerInfoDataModel.Success>, List<RealmWorkerModel>> {
    override fun map(model: List<WorkerInfoDataModel.Success>): List<RealmWorkerModel> =
        model.map { mapper.map(it) }
}