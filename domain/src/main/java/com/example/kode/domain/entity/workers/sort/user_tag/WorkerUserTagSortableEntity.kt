package com.example.kode.domain.entity.workers.sort.user_tag

import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity

class WorkerUserTagSortableEntity(
    id: String,
    avatarUrl: String,
    name: String,
    lastName: String,
    userTag: String,
    position: String
) : WorkerStringSortableEntity(id, avatarUrl, name, lastName, userTag, position) {

    override fun sortValue(): String = userTag
}