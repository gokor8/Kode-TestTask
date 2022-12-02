package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.AbstractSortUseCase
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.sort.by_string.StringSortableModel
import com.example.kode.domain.entity.sort.by_string.StringSortableState
import kotlin.coroutines.CoroutineContext

class StringStateSortUseCase<SS : StringSortableState<SS, SM>, SM : StringSortableModel, RM : UseCaseModel>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RM>,
    private val toStateMapper: Base.Mapper<SS, RM>,
) : AbstractSortUseCase<SS, RM>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: SS): RM {
        return equalsAttribute.getSortableList()
            .sortedBy { it.sortValue() }
            .let(equalsAttribute::copyByModel)
            .let(toStateMapper::map)
    }
}