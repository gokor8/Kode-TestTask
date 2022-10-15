package com.example.kode.domain.entity.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel

data class WorkerInfoEntity(
    val id: String,
    val avatarUrl: String,
    val name: String,
    val lastName: String,
    val userTag: String,
    val position: String
) : UseCaseModel<WorkerInfoEntity> {

    override fun <I : Base.Mapper<WorkerInfoEntity, R>, R> map(model: I): R = model.map(this)
}