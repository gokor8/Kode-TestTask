package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base

interface GetWorkersUseCase<M : Base.IgnorantMapper<M>> {

    suspend fun getWorkers(): M
}