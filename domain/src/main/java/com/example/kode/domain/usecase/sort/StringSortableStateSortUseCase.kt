package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.entity.sort.by_string.StringSortableModel
import com.example.kode.domain.entity.sort.by_string.StringSortableState
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class StringSortableStateSortUseCase<SS : StringSortableState<SS, SM>, SM : StringSortableModel, RM : UseCaseModel>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RM>,
    toStateMapper: Base.Mapper<SS, RM>,
) : StateSortUseCase<StringSortEntity<SS, SM>, SS, RM>(coroutineContext, failMapper, toStateMapper) {

    override fun sort(equalsAttribute: StringSortEntity<SS, SM>): SS = with(equalsAttribute) {
        sortableModel.getSortableList().sortedBy { it.sortValue() }
            .let(sortableModel::copy)
    }
}