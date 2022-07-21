package com.example.kode.data.repository.workers.models

import com.example.kode.domain.core.Base

sealed class WorkerInfoDataModel : Base.IgnorantMapper<WorkerInfoDataModel> {

    override fun <I : Base.Mapper<WorkerInfoDataModel, R>, R> map(model: I): R = model.map(this)

    data class Success(
        val id: String,
        val avatarUrl: String,
        val firstName: String,
        val lastName: String,
        val userTag: String,
        val department: String,
        val position: String,
        val birthday: List<String>,
        val phone: String
    ) : WorkerInfoDataModel()
}