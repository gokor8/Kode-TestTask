package com.example.kode.domain.entity.workers

import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.domain.usecase.workers.mappers.WorkersNameSortableStateToWorkersState

class WorkersNameSortableStateEntity(
    listSortable: List<WorkerNameSortableEntity>,
) : WorkersSortableStateEntity<WorkersNameSortableStateEntity, WorkerNameSortableEntity>(
    listSortable
) {

    override fun copyByModel(model: List<WorkerNameSortableEntity>): WorkersNameSortableStateEntity {
        return WorkersNameSortableStateEntity(listSortable)
    }
}