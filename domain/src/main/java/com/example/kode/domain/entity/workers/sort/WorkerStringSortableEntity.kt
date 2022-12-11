package com.example.kode.domain.entity.workers.sort

import com.example.kode.domain.entity.sort.by_string.StringSortableModel

abstract class WorkerStringSortableEntity(
    val id: String,
    val avatarUrl: String,
    val name: String,
    val lastName: String,
    val userTag: String,
    val position: String
) : StringSortableModel