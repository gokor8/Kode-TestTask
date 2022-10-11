package com.example.kode.domain.repository

import com.example.kode.domain.core.Repository
import com.example.kode.domain.core.usecase.UseCaseModel

interface WorkerRepository<IM : UseCaseModel<IM>, M : UseCaseModel<M>> : Repository {

    suspend fun getWorker(model: IM): M
}