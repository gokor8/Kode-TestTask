package com.example.kode.test_task.di.modules.data.cloud

import com.example.kode.data.datasource.workers.cloud.api.WorkersApi
import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.data.datasource.workers.cloud.service.WorkersServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [PCloudModule::class])
class PServiceModule {

    @Provides
    fun bindWorkersService(api: WorkersApi): WorkersService<List<WorkerInfoResponse>> =
        WorkersServiceImpl(api)
}