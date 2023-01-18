package com.example.kode.domain.entity.workers.sort

import com.example.kode.domain.entity.sort.by_string.StringSortableState

sealed class WorkersSortableStateEntity(
    protected val listSortable: List<WorkerStringSortableEntity>,
) : StringSortableState<WorkersSortableStateEntity, WorkerStringSortableEntity> {

    override fun getSortableList(): List<WorkerStringSortableEntity> = listSortable
}