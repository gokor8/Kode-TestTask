package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.entity.sort.by_string.StringSortableModel
import com.example.kode.domain.entity.sort.by_string.StringSortableState
import kotlin.coroutines.CoroutineContext

class StringStateSortUseCase<SS : StringSortableState<SS, SM>, SM : StringSortableModel, RM : UseCaseModel>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RM>,
    toStateMapper: Base.Mapper<SS, RM>,
) : AbstractStateSortUseCase<StringSortEntity<SS, SM>, SS, RM>(coroutineContext, failMapper, toStateMapper) {

    override fun sort(equalsAttribute: StringSortEntity<SS, SM>): SS = with(equalsAttribute) {
        sortableModel.getSortableList().filter { it.sortValue().contains(sortableValue) }
            .let(sortableModel::copyByModel)
    }
}