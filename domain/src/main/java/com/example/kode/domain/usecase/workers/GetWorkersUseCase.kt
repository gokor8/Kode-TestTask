package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersEntity
import com.example.kode.domain.repository.WorkersRepository

class GetWorkersUseCase<M : Base.FuncMapper>(
    private val workersRepository: WorkersRepository<M>,
    private val failMapper: Base.Mapper<Exception, M>
) {

    fun getWorkers(): M = try {
        workersRepository.getWorkers()
    } catch (e: Exception) {
        failMapper.map(e)
    }
}