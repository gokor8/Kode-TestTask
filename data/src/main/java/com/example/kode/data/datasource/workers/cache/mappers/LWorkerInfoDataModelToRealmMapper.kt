package com.example.kode.data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

class LWorkerInfoDataModelToRealmMapper @Inject constructor(
    private val mapper: Base.Mapper<WorkerInfoDataModel, RealmWorkerModel>
) :
    Base.Mapper<WorkersInfoStateDataModel, MutableList<RealmWorkerModel>> {
    override fun map(model: WorkersInfoStateDataModel): MutableList<RealmWorkerModel> =
        (model as WorkersInfoStateDataModel.Cloud).workers.map { mapper.map(it) }.toMutableList()
}