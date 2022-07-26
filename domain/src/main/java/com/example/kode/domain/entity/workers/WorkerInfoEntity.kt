package com.example.kode.domain.entity.workers

import com.example.kode.domain.core.Base

data class WorkerInfoEntity(
    val avatarUrl: String,
    val name: String,
    val lastName: String,
    val userTag: String,
    val position: String
) : Base.IgnorantMapper<WorkerInfoEntity> {

    override fun <I : Base.Mapper<WorkerInfoEntity, R>, R> map(model: I): R = model.map(this)
}