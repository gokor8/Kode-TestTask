package com.example.kode.test_task.di.modules.domain

import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSource
import com.example.kode.data.repository.workers.WorkersRepositoryImpl
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.repository.WorkersRepository
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.domain.usecase.workers.GetWorkersUseCaseImpl
import com.example.kode.test_task.di.modules.PCoroutineDispatcherModule
import com.example.kode.test_task.di.modules.data.PRepositoryModule
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher

@Module(includes = [PCoroutineDispatcherModule::class, PRepositoryModule::class, PMapperModule::class])
class PUseCaseModule {

    @Provides
    fun provideGetWorkersUseCase(
        dispatcher: CoroutineDispatcher,
        repository: WorkersRepository<WorkersStateEntity>,
        mapper: Base.Mapper<Exception, WorkersStateEntity>
    ) : GetWorkersUseCase<WorkersStateEntity> = GetWorkersUseCaseImpl(dispatcher, repository, mapper)

}