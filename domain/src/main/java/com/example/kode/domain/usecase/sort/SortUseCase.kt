package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Read
import com.example.kode.domain.core.sort.SortUseCaseModel
import com.example.kode.domain.core.sort.SortableUseCaseModel
import com.example.kode.domain.core.usecase.UseCaseSuspend
import com.example.kode.domain.entity.workers.WorkerSortableEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SortUseCase<SUM : SortableUseCaseModel<*>, RM> @Inject constructor(
    private val mapper: Base.Mapper<List<SUM>, RM>,
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, RM>,
) : UseCaseSuspend.UseCaseWithInput<SortUseCaseModel<SUM>, RM>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: SortUseCaseModel<SUM>) =
        equalsAttribute.sort().let(mapper::map)
}