package com.example.kode.data.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.workers.WorkersEntity

sealed class WorkersDataModel : Base.IgnorantMapper<WorkersDataModel>, Base.Model {

    data class SuccessDataModel(
        val name: String,
        val lastName: String,
        val userTag: String,
        val position: String
    ) : WorkersDataModel() {
        override fun <I : Base.Mapper<WorkersDataModel, R>, R> map(model: I): R = model.map(this)
    }

    data class FailDataModel(val title: String, val Description: String) : WorkersDataModel() {
        override fun <I : Base.Mapper<WorkersDataModel, R>, R> map(model: I): R = model.map(this)
    }
}