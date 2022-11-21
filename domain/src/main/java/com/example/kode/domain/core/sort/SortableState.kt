package com.example.kode.domain.core.sort

interface SortableState<C : Collection<M>, M : SortableModel<*>> {

    fun getSortableList(): C
}