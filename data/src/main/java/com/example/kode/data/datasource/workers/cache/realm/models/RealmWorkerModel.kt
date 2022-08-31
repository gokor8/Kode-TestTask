package com.example.kode.data.datasource.workers.cache.realm.models

import com.example.kode.domain.core.Base
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required

open class RealmWorkerModel(
    @PrimaryKey
    var id: String = "",
    @Required
    var avatarUrl: String = "",
    @Required
    var name: String = "",
    @Required
    var lastName: String = "",
    @Required
    var userTag: String = "",
    @Required
    var department: String = "",
    @Required
    var position: String = "",
    @Required
    var birthday: String = "",
    @Required
    var phone: String = ""
) : RealmObject(), Base.IgnorantMapper<RealmWorkerModel> {

    override fun <I : Base.Mapper<RealmWorkerModel, R>, R> map(model: I) = model.map(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RealmWorkerModel) return false

        if (id != other.id) return false
        if (avatarUrl != other.avatarUrl) return false
        if (name != other.name) return false
        if (lastName != other.lastName) return false
        if (userTag != other.userTag) return false
        if (department != other.department) return false
        if (position != other.position) return false
        if (birthday != other.birthday) return false
        if (phone != other.phone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + avatarUrl.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + userTag.hashCode()
        result = 31 * result + department.hashCode()
        result = 31 * result + position.hashCode()
        result = 31 * result + birthday.hashCode()
        result = 31 * result + phone.hashCode()
        return result
    }
}
