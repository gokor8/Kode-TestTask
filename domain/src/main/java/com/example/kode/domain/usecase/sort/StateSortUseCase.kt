package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.AbstractSortUseCase
import com.example.kode.domain.core.sort.SortableState
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.sort.BaseSortEntity
import kotlin.coroutines.CoroutineContext

abstract class StateSortUseCase<SE : BaseSortEntity<SS, *, *>, SS : SortableState<SS, *>, RM : UseCaseModel>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RM>,
    private val toStateMapper: Base.Mapper<SS, RM>,
) : AbstractSortUseCase<SE, RM>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: SE): RM = sort(equalsAttribute)
        .let(toStateMapper::map)

    abstract fun sort(equalsAttribute: SE): SS
}