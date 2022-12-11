package com.example.kode.domain.entity.workers.sort

import com.example.kode.domain.entity.sort.by_string.StringSortableState

abstract class WorkersSortableStateEntity<SM : WorkerStringSortableEntity>(
    protected val listSortable: List<SM>
) : StringSortableState<WorkersSortableStateEntity<SM>, SM> {

    override fun getSortableList(): List<SM> = listSortable
}