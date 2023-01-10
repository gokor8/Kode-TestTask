package com.example.kode.domain.entity.workers.sort

import javax.inject.Inject

class WorkersCacheSortableStateEntity @Inject constructor(
    listSortable: List<WorkerStringSortableEntity>,
) : WorkersSortableStateEntity(
    listSortable
) {
    override fun copyByModel(model: List<WorkerStringSortableEntity>): WorkersSortableStateEntity {
        return WorkersCacheSortableStateEntity(model)
    }
}
