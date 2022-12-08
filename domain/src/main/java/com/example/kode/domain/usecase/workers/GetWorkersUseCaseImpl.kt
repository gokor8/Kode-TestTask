package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.ToSortModel
import com.example.kode.domain.core.sort.UseCaseSortableModel
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.core.usecase.UseCaseSuspend
import com.example.kode.domain.repository.WorkersRepository
import com.example.kode.domain.usecase.sort.AbstractStateSortableUseCase
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetWorkersUseCaseImpl<SM : UseCaseSortableModel, M : UseCaseModel> @Inject constructor(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, M>,
    private val workersRepository: WorkersRepository<M>,
    private val toSortModelMapper: Base.Mapper<M, SM>,
    private val stateSortableUseCase: AbstractStateSortableUseCase<SM, M>,
) : GetWorkersUseCase<M>(coroutineContext, failMapper) {

    override suspend fun getSafely(): M {
        val workersState = workersRepository.getWorkers()

        return if (workersState is ToSortModel<SM>)
            stateSortableUseCase.get(workersState.let(toSortModelMapper::map))
        else
            workersState
    }
}
