package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.AbstractSortUseCase
import com.example.kode.domain.core.sort.SortableState
import com.example.kode.domain.core.usecase.UseCaseModel
import java.lang.Exception
import kotlin.coroutines.CoroutineContext

class SortableStateSortUseCase<SS : SortableState<SS, *, *>, RM : UseCaseModel>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RM>,
    private val sortMapper: Base.Mapper<SS, SS>
    private val toStateMapper: Base.Mapper<SS, RM>,
) : AbstractSortUseCase<SS, RM>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: SS): RM {
        return sortMapper.map(equalsAttribute).let(toStateMapper::map)
    }
}