package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.AbstractSortUseCase
import com.example.kode.domain.core.sort.SortableModel
import com.example.kode.domain.core.sort.SortableState
import com.example.kode.domain.entity.sort.BaseSortEntity
import com.example.kode.domain.usecase.sort.by_string.StringSortEntity
import com.example.kode.domain.usecase.sort.by_string.StringSortableModel
import com.example.kode.domain.usecase.sort.by_string.StringSortableState
import kotlin.coroutines.CoroutineContext

class StringStateSortUseCase<RSM : StringSortableState<RSM, SM>, SM : StringSortableModel>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RSM>,
) : AbstractSortUseCase<StringSortEntity<RSM, SM>, RSM>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: StringSortEntity<RSM, SM>): RSM =
        with(equalsAttribute) {
            "a" == "b"
            sortableModel.getSortableList()
                .filter { sortableValue == it.sortValue() }
                .let(sortableModel::copy)
        }
}

