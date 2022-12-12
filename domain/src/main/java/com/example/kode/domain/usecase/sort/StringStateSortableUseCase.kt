package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.sort.by_string.StringSortableModel
import com.example.kode.domain.entity.sort.by_string.StringSortableState
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class StringStateSortableUseCase
<SS : StringSortableState<SS, SM>, SM : StringSortableModel, RM : UseCaseModel> @Inject constructor(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RM>,
    toStateMapper: Base.Mapper<SS, RM>,
) : AbstractStateSortableUseCase<SS, RM>(coroutineContext, failMapper, toStateMapper) {

    override fun sort(equalsAttribute: SS): SS = equalsAttribute.getSortableList()
        .sortedBy { it.sortValue() }
        .let(equalsAttribute::copyByModel)
}