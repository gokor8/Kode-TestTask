package com.example.kode.domain.entity.workers.sort

import javax.inject.Inject

class WorkersCloudSortableStateEntity @Inject constructor(
    listSortable: List<WorkerStringSortableEntity>,
) : WorkersSortableStateEntity(
    listSortable
) {
    override fun copyByModel(model: List<WorkerStringSortableEntity>): WorkersSortableStateEntity {
        return WorkersCloudSortableStateEntity(model)
    }
}
