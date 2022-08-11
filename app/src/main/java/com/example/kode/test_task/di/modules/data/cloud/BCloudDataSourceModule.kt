package com.example.kode.test_task.di.modules.data.cloud

import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSource
import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSourceImpl
import com.example.kode.data.datasource.workers.cloud.api.WorkersApi
import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [PServiceModule::class, BCloudDataSourceMapperModule::class])
abstract class BCloudDataSourceModule {

    @Binds
    abstract fun bindWorkersCloudDataSource(dataSource: WorkersCloudDataSourceImpl<WorkersInfoStateDataModel, List<WorkerInfoResponse>>)
            : WorkersCloudDataSource<WorkersInfoStateDataModel>
}