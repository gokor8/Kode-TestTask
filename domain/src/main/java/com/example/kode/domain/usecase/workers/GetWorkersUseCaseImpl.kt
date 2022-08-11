package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.repository.WorkersRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetWorkersUseCaseImpl<M : Base.IgnorantMapper<M>> @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val workersRepository: WorkersRepository<M>,
    private val failMapper: Base.Mapper<Exception, M>
) : GetWorkersUseCase<M> {

    override suspend fun getWorkers(): M = withContext(dispatcher) {
        try {
            workersRepository.getWorkers()
        } catch (e: Exception) {
            failMapper.map(e)
        }
    }
}
