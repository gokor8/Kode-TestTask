package com.example.kode.data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base

class LWorkerInfoDataModelToRealmMapper(
    private val mapper: Base.Mapper<WorkerInfoDataModel, RealmWorkerModel>
) :
    Base.Mapper<WorkersInfoStateDataModel.Success, List<RealmWorkerModel>> {
    override fun map(model: WorkersInfoStateDataModel.Success): List<RealmWorkerModel> =
        model.workers.map { mapper.map(it) }
}