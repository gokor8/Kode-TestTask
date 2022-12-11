package com.example.kode.domain.entity.workers

import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity

class WorkerNameSortableEntity(
    id: String,
    avatarUrl: String,
    name: String,
    lastName: String,
    userTag: String,
    position: String
) : WorkerStringSortableEntity(id, avatarUrl, name, lastName, userTag, position) {

    override fun sortValue(): String = name + lastName
}