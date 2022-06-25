package com.example.kode.domain.usecase

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersEntity
import com.example.kode.domain.repository.WorkersRepository

class GetWorkersUseCase(
    private val workersRepository: WorkersRepository<WorkersEntity>,
    private val failMapper: Base.Mapper<Exception, WorkersEntity>
) {

    fun getWorkers(): WorkersEntity = try {
        workersRepository.getWorkers()
    } catch (e: Exception) {
        failMapper.map(e)
    }
}