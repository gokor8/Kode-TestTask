package com.example.kode.test_task.di.modules.data

import com.example.kode.data.datasource.workers.cache.RealmWorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSource
import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSourceImpl
import com.example.kode.data.repository.workers.WorkersRepositoryImpl
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.repository.WorkersRepository
import com.example.kode.test_task.di.modules.data.cache.PCacheDataSourceModule
import com.example.kode.test_task.di.modules.data.cloud.BCloudDataSourceModule
import dagger.Module
import dagger.Provides

@Module(includes = [BCloudDataSourceModule::class, BMapperModule::class, PCacheDataSourceModule::class])
class PRepositoryModule {

    @Provides
    fun provideWorkersRepository(
        workersCloudDataSourceImpl: WorkersCloudDataSource<WorkersInfoStateDataModel>,
        workersCacheDataSource: WorkersCacheDataSource<WorkersInfoStateDataModel>,
        mapper: Base.Mapper<WorkersInfoStateDataModel, WorkersStateEntity>
    ): WorkersRepository<WorkersStateEntity> =
        WorkersRepositoryImpl(workersCloudDataSourceImpl, workersCacheDataSource, mapper)
}