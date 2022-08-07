package com.example.kode.test_task.di.modules.data

import com.example.kode.data.repository.workers.WorkersRepositoryImpl
import com.example.kode.domain.repository.WorkersRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BRepositoryModule {

    @Binds
    abstract fun bindWorkersRepository(repository: WorkersRepositoryImpl<>)
}