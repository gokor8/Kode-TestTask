package com.example.kode.data.datasource.workers.cache.room.models

import com.example.kode.data.datasource.core.DataSourceModel
import com.example.kode.domain.core.Base

class RoomFindWorkerModel(
    val id: String
) : DataSourceModel<RoomFindWorkerModel> {
    override fun <I : Base.Mapper<RoomFindWorkerModel, R>, R> map(model: I): R = model.map(this)
}