package com.example.kode.test_task.di.modules.domain

import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.domain.usecase.workers.GetWorkersUseCaseImpl
import com.example.kode.test_task.di.modules.PCoroutineDispatcherModule
import com.example.kode.test_task.di.modules.data.PRepositoryModule
import dagger.Binds
import dagger.Module

/*
@Module(includes = [PCoroutineDispatcherModule::class, PRepositoryModule::class, PMapperModule::class])
abstract class BUseCaseModule {

    @Binds
    abstract fun bindGetWorkersUseCase(useCase: GetWorkersUseCaseImpl<WorkersStateEntity>): GetWorkersUseCase<WorkersStateEntity>
}*/