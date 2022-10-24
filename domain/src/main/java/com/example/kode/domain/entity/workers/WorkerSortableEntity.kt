package com.example.kode.domain.entity.workers

import com.example.kode.domain.core.sort.SortableUseCaseModel

abstract class WorkerSortableEntity(
    id: String,
    avatarUrl: String,
    name: String,
    lastName: String,
    userTag: String,
    position: String,
): WorkerInfoEntity(id, avatarUrl, name, lastName, userTag, position), SortableUseCaseModel<String>