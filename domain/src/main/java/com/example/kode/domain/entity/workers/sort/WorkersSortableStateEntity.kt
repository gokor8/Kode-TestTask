package com.example.kode.domain.entity.workers.sort

import com.example.kode.domain.entity.sort.by_string.StringSortableState

class WorkersSortableStateEntity(
    protected val listSortable: List<WorkerStringSortableEntity>,
) : StringSortableState<WorkersSortableStateEntity, WorkerStringSortableEntity> {

    override fun getSortableList(): List<WorkerStringSortableEntity> = listSortable

    override fun copyByModel(model: List<WorkerStringSortableEntity>): WorkersSortableStateEntity {
        return WorkersSortableStateEntity(model)
    }
}