package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.AbstractSortUseCase
import com.example.kode.domain.core.sort.SortUseCase
import com.example.kode.domain.core.sort.UseCaseSortableModel
import com.example.kode.domain.core.usecase.UseCaseModel
import kotlin.coroutines.CoroutineContext

abstract class AbstractStateSortableUseCase<I : UseCaseSortableModel, R : UseCaseModel>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, R>,
    private val toStateMapper: Base.Mapper<I, R>,
) : AbstractSortUseCase<I, R>(coroutineContext, failMapper), SortUseCase<I, R> {

    override suspend fun withSafe(equalsAttribute: I): R = sort(equalsAttribute)
        .let(toStateMapper::map)

    protected abstract fun sort(equalsAttribute: I): I
}