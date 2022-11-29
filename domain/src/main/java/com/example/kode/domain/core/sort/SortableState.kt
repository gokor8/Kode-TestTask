package com.example.kode.domain.core.sort

import com.example.kode.domain.core.Copy

interface SortableState<SS : SortableState<SS, SM>, SM : SortableModel<*>>
    : UseCaseSortableModel, Copy<List<SM>, SS> {

    fun getSortableList(): List<SM>
}