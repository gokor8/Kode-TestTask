package com.example.kode.domain.entity.workers

class WorkerSortablePositionEntity(
    id: String,
    avatarUrl: String,
    name: String,
    lastName: String,
    userTag: String,
    position: String,
) : WorkerSortableEntity(id, avatarUrl, name, lastName, userTag, position) {

    override fun isFit(sortModel: String) = position == sortModel
}