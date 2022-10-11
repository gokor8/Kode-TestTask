package com.example.kode.domain.usecase.worker

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.repository.WorkerRepository
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetWorkerUseCaseImpl<IM : UseCaseModel<IM>, M : UseCaseModel<M>> @Inject constructor(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, M>,
    private val getWorkerRepository: WorkerRepository<IM, M>,
) : GetWorkerUseCase<IM, M>(coroutineContext, failMapper) {

    override suspend fun withSafe(equalsAttribute: IM): M =
        getWorkerRepository.getWorker(equalsAttribute)
}