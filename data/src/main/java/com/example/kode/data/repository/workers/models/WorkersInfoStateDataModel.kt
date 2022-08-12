package com.example.kode.data.repository.workers.models

import com.example.kode.domain.core.Base

sealed class WorkersInfoStateDataModel : Base.IgnorantMapper<WorkersInfoStateDataModel>{

    override fun <I : Base.Mapper<WorkersInfoStateDataModel, R>, R> map(model: I): R = model.map(this)

    data class Success(
        val workers: MutableList<WorkerInfoDataModel>
    ) : WorkersInfoStateDataModel()
}
