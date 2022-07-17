package com.example.kode.data.datasource.workers.cache.models

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
) : RealmObject()