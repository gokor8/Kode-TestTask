package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.core.usecase.UseCaseSuspend
import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.entity.sort.by_string.StringSortableState
import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.domain.usecase.sort.StringStateSortUseCase
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class WorkersSearchUseCase<I : Any, R : UseCaseModel>
@Inject constructor(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, R>,
    private val searchSortUseCase: StringStateSortUseCase<WorkersSortableStateEntity, WorkerStringSortableEntity, R>,
    private val toSortMapper: Base.Mapper<I, StringSortEntity<WorkersSortableStateEntity, WorkerStringSortableEntity>>,
) : UseCaseSuspend.UseCaseWithInput<I, R>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: I): R = searchSortUseCase.get(
        equalsAttribute.let(toSortMapper::map)
    )
}