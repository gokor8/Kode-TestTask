package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.AbstractSortUseCase
import com.example.kode.domain.core.sort.SortableModel
import com.example.kode.domain.core.sort.SortableState
import com.example.kode.domain.core.usecase.UseCaseModel
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

/*
class SortableStateSortUseCase<SS : SortableState<SS, SM>, SM : SortableModel<*>, RM : UseCaseModel>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RM>,
    protected val toStateMapper: Base.Mapper<SS, RM>,
) : AbstractSortUseCase<SS, RM>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: SS): RM {
        return equalsAttribute.getSortableList().sortedBy { it.sortValue() }
            .let(equalsAttribute::copyByModel)
            .let(toStateMapper::map)
    }
}*/
