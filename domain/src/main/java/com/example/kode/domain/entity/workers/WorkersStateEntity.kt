package com.example.kode.domain.entity.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions

sealed class WorkersStateEntity : Base.IgnorantMapper<WorkersStateEntity> {

    override fun <I : Base.Mapper<WorkersStateEntity, R>, R> map(model: I): R = model.map(this)

    data class Success(
        val name: String,
        val lastName: String,
        val userTag: String,
        val position: String
    ) : WorkersStateEntity()

    data class Fail(val exception: Exceptions): WorkersStateEntity()
}
