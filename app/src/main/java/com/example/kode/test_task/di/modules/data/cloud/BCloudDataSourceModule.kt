package com.example.kode.test_task.di.modules.data.cloud

import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSource
import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSourceImpl
import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import dagger.Binds
import dagger.Module

@Module(includes = [BServiceModule::class, BCloudDataSourceMapperModule::class])
interface BCloudDataSourceModule {

    @Binds
    fun bindWorkersCloudDataSource(dataSource: WorkersCloudDataSourceImpl<WorkersInfoStateDataModel, MutableList<WorkerInfoResponse>>)
            : WorkersCloudDataSource<WorkersInfoStateDataModel>
}