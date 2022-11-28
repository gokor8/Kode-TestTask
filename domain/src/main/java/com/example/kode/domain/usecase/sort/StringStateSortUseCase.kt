package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.AbstractSortUseCase
import com.example.kode.domain.core.sort.SortableModel
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.entity.sort.by_string.StringSortableModel
import com.example.kode.domain.entity.sort.by_string.StringSortableState
import kotlin.coroutines.CoroutineContext

class StringStateSortUseCase<RSM : StringSortableState<RSM, SM>, SM : StringSortableModel, RM : UseCaseModel>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RM>,
    private val sortMapper: SortMapper<SM, *>,
    private val toStateMapper: Base.Mapper<RSM, RM>,
) : AbstractSortUseCase<StringSortEntity<RSM, *>, RM>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: StringSortEntity<RSM, *>): RM =
        with(equalsAttribute) {
            sortMapper.map(sortableModel)
            sortableModel.getSortableList()
                .filter { it.sortValue().contains(sortableValue) }
                .let(sortableModel::copy)
                .let(toStateMapper::map)
        }
}

