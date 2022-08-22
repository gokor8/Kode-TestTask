package com.example.kode.domain.repository

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.RepositoryEntity
import com.example.kode.domain.core.UseCaseModel

interface WorkersRepository<R : UseCaseModel<R>> : RepositoryEntity {

    suspend fun getWorkers(): R
}