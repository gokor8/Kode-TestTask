package com.example.kode.data.repository.worker.models

import com.example.kode.data.datasource.core.DataSourceModel
import com.example.kode.domain.core.Base

class WorkerInputDataModel(
    val userId: String
) : DataSourceModel<WorkerInputDataModel> {
    override fun <I : Base.Mapper<WorkerInputDataModel, R>, R> map(model: I): R = model.map(this)
}