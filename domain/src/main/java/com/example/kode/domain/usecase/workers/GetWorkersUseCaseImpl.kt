package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.core.usecase.UseCaseSuspend
import com.example.kode.domain.repository.WorkersRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetWorkersUseCaseImpl<M : UseCaseModel> @Inject constructor(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, M>,
    private val workersRepository: WorkersRepository<M>
) : GetWorkersUseCase<M>(coroutineContext, failMapper) {

    override suspend fun getSafely(): M = workersRepository.getWorkers()
}
