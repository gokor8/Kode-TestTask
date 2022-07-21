package com.example.kode.data.datasource.workers.cloud.models

import com.example.kode.domain.core.Base

data class WorkerInfoResponse(
    val id: String,
    val avatarUrl: String,
    val firstName: String,
    val lastName: String,
    val userTag: String,
    val department: String,
    val position: String,
    val birthday: List<String>,
    val phone: String
) : Base.IgnorantMapper<WorkerInfoResponse> {
    override fun <I : Base.Mapper<WorkerInfoResponse, R>, R> map(model: I): R = model.map(this)
}