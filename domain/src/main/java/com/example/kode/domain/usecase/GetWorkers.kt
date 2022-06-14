package com.example.kode.domain.usecase

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.BaseState
import com.example.kode.domain.entity.fail.SimpleFail
import com.example.kode.domain.repository.WorkersRepository

class GetWorkers(
    private val workersRepository: WorkersRepository,
    private val failMapper: Base.Mapper<Exception, SimpleFail>
) {

    fun getWorkers() : BaseState = try {
        workersRepository.getWorkers()
    } catch (e: Exception) {
        failMapper.map(e)
    }
}