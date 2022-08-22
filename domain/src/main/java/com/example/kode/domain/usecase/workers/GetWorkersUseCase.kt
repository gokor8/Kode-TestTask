package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.UseCaseModel

interface GetWorkersUseCase<M : UseCaseModel<M>> {

    suspend fun getWorkers(): M
}