package com.example.kode.domain.entity.workers

class WorkerSortableNickEntity(
    id: String,
    avatarUrl: String,
    name: String,
    lastName: String,
    userTag: String,
    position: String,
) : WorkerSortableEntity(id, avatarUrl, name, lastName, userTag, position) {

    override fun isFit(sortModel: String) = userTag.contains(sortModel)
}