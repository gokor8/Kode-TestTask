package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.FilterableUseCaseModel
import com.example.kode.domain.core.sort.SortableUseCaseModel
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.repository.WorkersRepository
import com.example.kode.domain.usecase.sort.SortUseCase
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetWorkersUseCaseImpl<M : UseCaseModel> @Inject constructor(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, M>,
    private val workersRepository: WorkersRepository<M>,
    private val sortUseCase: SortUseCase<WorkerInfoEntity, M>,
    private val toSortState: Base.Mapper<M, List<WorkerInfoEntity>>,
) : GetWorkersUseCase<M, String>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: String?): M {
        val workersState = workersRepository.getWorkers()

        if (equalsAttribute == null) return workersState

        val workersList = workersState.let(toSortState::map)

        if (workersList.isEmpty()) {
            return workersState
        }

        return sortUseCase.get(FilterableUseCaseModel(equalsAttribute, workersList))
    }
}
