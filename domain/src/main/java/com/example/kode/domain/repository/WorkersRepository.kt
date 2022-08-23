package com.example.kode.domain.repository

import com.example.kode.domain.core.Repository
import com.example.kode.domain.core.usecase.UseCaseModel

interface WorkersRepository<R : UseCaseModel<R>> : Repository {

    suspend fun getWorkers(): R
}