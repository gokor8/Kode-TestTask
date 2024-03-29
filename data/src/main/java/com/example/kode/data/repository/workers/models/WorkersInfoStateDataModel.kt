package com.example.kode.data.repository.workers.models

import com.example.kode.data.datasource.core.DataSourceModel
import com.example.kode.domain.core.Base

sealed class WorkersInfoStateDataModel : DataSourceModel<WorkersInfoStateDataModel>{

    override fun <I : Base.Mapper<WorkersInfoStateDataModel, R>, R> map(model: I): R = model.map(this)

    data class Cloud(
        val workers: MutableList<WorkerInfoDataModel>
    ) : WorkersInfoStateDataModel()

    data class Cache(
        val workers: List<WorkerInfoDataModel>
    ) : WorkersInfoStateDataModel()
}
