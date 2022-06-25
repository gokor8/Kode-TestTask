package com.example.kode.data.workers.model

import com.example.kode.domain.core.Base

sealed class WorkersDataModel : Base.IgnorantMapper<WorkersDataModel>, Base.Model {

    data class Success(
        val name: String,
        val lastName: String,
        val userTag: String,
        val position: String
    ) : WorkersDataModel() {
        override fun <I : Base.Mapper<WorkersDataModel, R>, R> map(model: I): R = model.map(this)
    }

    data class Fail(val title: String, val Description: String) : WorkersDataModel() {
        override fun <I : Base.Mapper<WorkersDataModel, R>, R> map(model: I): R = model.map(this)
    }
}