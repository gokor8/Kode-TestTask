package com.example.kode.domain.entity.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions

sealed class WorkersEntity : Base.IgnorantMapper<WorkersEntity> {

    override fun <I : Base.Mapper<WorkersEntity, R>, R> map(model: I): R = model.map(this)

    data class SuccessEntity(
        val name: String,
        val lastName: String,
        val userTag: String,
        val position: String
    ) : WorkersEntity()

    data class FailEntity(val exception: Exceptions): WorkersEntity()
}
