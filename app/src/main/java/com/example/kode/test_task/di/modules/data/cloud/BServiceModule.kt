package com.example.kode.test_task.di.modules.data.cloud

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse
import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.data.datasource.workers.cloud.service.WorkersServiceImpl
import dagger.Binds
import dagger.Module

@Module(includes = [PCloudModule::class])
interface BServiceModule {

    @Binds
    fun bindWorkersService(workersServiceImpl: WorkersServiceImpl): WorkersService<WorkersResponse>
}