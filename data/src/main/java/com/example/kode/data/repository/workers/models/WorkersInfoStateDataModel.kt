package com.example.kode.data.repository.workers.models

import com.example.kode.domain.core.Base

sealed class WorkersInfoStateDataModel {

    data class Success(
        val workers: List<WorkerInfoDataModel>
    ) : WorkersInfoStateDataModel(), Base.IgnorantMapper<Success> {
        override fun <I : Base.Mapper<Success, R>, R> map(model: I): R = model.map(this)
    }
}
