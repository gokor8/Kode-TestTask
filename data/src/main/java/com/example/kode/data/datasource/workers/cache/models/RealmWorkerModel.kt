package com.example.kode.data.datasource.workers.cache.models

import com.example.kode.domain.core.Base
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class RealmWorkerModel constructor(
    @PrimaryKey
    var pId: Int = 0,
    @Required
    var id: String = "",
    @Required
    val avatarUrl: String = "",
    @Required
    var name: String = "",
    @Required
    var lastName: String = "",
    @Required
    var userTag: String = "",
    @Required
    var department: String,
    @Required
    var position: String = "",
    @Required
    var birthday: List<String> = listOf(),
    @Required
    var phone: String = ""
) : RealmObject(), Base.IgnorantMapper<RealmWorkerModel> {

    override fun <I : Base.Mapper<RealmWorkerModel, R>, R> map(model: I) = model.map(this)
}