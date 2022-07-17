package com.example.kode.data.datasource.workers.cache.models

import com.example.kode.domain.core.Base
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

class RealmWorkersModel(
    @PrimaryKey
    var id: Int,
    @Required
    var name: String,
    @Required
    var lastName: String,
    @Required
    var userTag: String,
    @Required
    var position: String
) : RealmObject(), Base.IgnorantMapper<RealmWorkersModel> {

    override fun <I : Base.Mapper<RealmWorkersModel, R>, R> map(model: I) = model.map(this)
}