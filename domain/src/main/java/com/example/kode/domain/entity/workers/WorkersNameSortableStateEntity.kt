package com.example.kode.domain.entity.workers

import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity

class WorkersNameSortableStateEntity(
    listSortable: List<WorkerNameSortableEntity>,
) : WorkersSortableStateEntity<WorkerNameSortableEntity>(listSortable) {

    override fun copyByModel(model: List<WorkerNameSortableEntity>): WorkersSortableStateEntity<WorkerNameSortableEntity> {
        return WorkersNameSortableStateEntity(listSortable)
    }
}