package com.example.kode.data.repository.workers.models

import com.example.kode.domain.core.Base

sealed class WorkersDataModel : Base.IgnorantMapper<WorkersDataModel> {

    override fun <I : Base.Mapper<WorkersDataModel, R>, R> map(model: I): R = model.map(this)

    data class Success(
        val name: String,
        val lastName: String,
        val userTag: String,
        val position: String
    ) : WorkersDataModel()
}