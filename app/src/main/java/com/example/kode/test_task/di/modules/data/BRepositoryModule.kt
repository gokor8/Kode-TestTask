package com.example.kode.test_task.di.modules.data

import com.example.kode.data.repository.workers.WorkersRepositoryImpl
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.repository.WorkersRepository
import com.example.kode.test_task.di.modules.data.cloud.BCloudDataSourceModule
import dagger.Binds
import dagger.Module

/*
@Module(includes = [BCloudDataSourceModule::class, BMapperModule::class])
abstract class BRepositoryModule {

    @Binds
    abstract fun bindWorkersRepository(repository: WorkersRepositoryImpl<WorkersStateEntity, *>)
            : WorkersRepository<WorkersStateEntity>
}*/
