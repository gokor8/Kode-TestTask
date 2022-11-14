package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.EmptyFilterableUseCaseModel
import com.example.kode.domain.core.sort.FilterableCreator
import com.example.kode.domain.core.sort.SortableUseCaseModel
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.repository.WorkersRepository
import com.example.kode.domain.usecase.sort.SortUseCase
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetWorkersUseCaseImpl<M : UseCaseModel, SM : SortableUseCaseModel<*>> @Inject constructor(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, M>,
    private val workersRepository: WorkersRepository<M>,
    private val sortUseCase: SortUseCase<SM, M>,
    private val toSortState: Base.Mapper<M, List<SM>>,
) : GetWorkersUseCase<M, SM>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: FilterableCreator<SortableUseCaseModel<*>, SM>): M {
        val workersState = workersRepository.getWorkers()

        val workersList = workersRepository.getWorkers().let(toSortState::map)

        if (workersList.isEmpty()) {
            return workersState
        }

        return sortUseCase.get(equalsAttribute.createFilterable(workersList))
    }
}
