package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.UseCaseModel
import com.example.kode.domain.repository.WorkersRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class GetWorkersUseCaseImpl<M : UseCaseModel<M>> @Inject constructor(
    private val coroutineContext: CoroutineContext,
    private val workersRepository: WorkersRepository<M>,
    private val failMapper: Base.Mapper<Exception, M>
) : GetWorkersUseCase<M> {

    override suspend fun getWorkers(): M = withContext(coroutineContext) {
        try {
            workersRepository.getWorkers()
        } catch (e: Exception) {
            e.printStackTrace()
            failMapper.map(e)
        }
    }
}
