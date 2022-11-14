package com.example.kode.domain.core.sort

interface FilterableCreator<IM, RM : SortableUseCaseModel<*>> {
    fun createFilterable(toSortList: List<IM>): SortUseCaseModel<RM>
}