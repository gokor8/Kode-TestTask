package com.example.kode.domain.entity.workers.sort

import com.example.kode.domain.entity.sort.by_string.StringSortableState

abstract class WorkersSortableStateEntity<SS : WorkersSortableStateEntity<SS, SM>, SM : WorkerStringSortableEntity>(
    protected val listSortable: List<SM>,
) : StringSortableState<SS, SM> {

    override fun getSortableList(): List<SM> = listSortable
}