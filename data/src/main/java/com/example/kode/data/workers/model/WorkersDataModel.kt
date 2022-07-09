package com.example.kode.data.workers.model

import com.example.kode.domain.core.Base
import java.lang.Exception

sealed class WorkersDataModel : Base.IgnorantMapper<WorkersDataModel> {

    override fun <I : Base.Mapper<WorkersDataModel, R>, R> map(model: I): R = model.map(this)

    data class Success(
        val name: String,
        val lastName: String,
        val userTag: String,
        val position: String
    ) : WorkersDataModel()
}