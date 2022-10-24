package com.example.kode.domain.core.sort

import javax.inject.Inject

class FilterableUseCaseModel<RM : SortableUseCaseModel<M>, M> @Inject constructor(
    private val sortByValue: M,
    private val sortableModel: List<RM>
) : SortUseCaseModel<RM> {

    override fun sort(): List<RM> = sortableModel.filter { it.isFit(sortByValue) }
}