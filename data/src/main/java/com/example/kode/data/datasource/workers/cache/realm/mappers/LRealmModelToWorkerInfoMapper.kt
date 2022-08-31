package com.example.kode.data.datasource.workers.cache.realm.mappers

import com.example.kode.data.datasource.workers.cache.realm.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

class LRealmModelToWorkerInfoMapper @Inject constructor(
    private val mapper: Base.Mapper<RealmWorkerModel, WorkerInfoDataModel>
) : Base.Mapper<MutableList<RealmWorkerModel>, WorkersInfoStateDataModel> {

    override fun map(model: MutableList<RealmWorkerModel>): WorkersInfoStateDataModel =
        WorkersInfoStateDataModel.Cache(model.map { it.map(mapper) }.toMutableList())
}