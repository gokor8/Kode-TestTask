package com.example.kode.test_task.di.modules.data.cloud

import com.example.kode.data.datasource.workers.cloud.mappers.LWorkerInfoResponseToLDataMapperImpl
import com.example.kode.data.datasource.workers.cloud.mappers.WorkerInfoResponseToDataMapper
import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import dagger.Binds
import dagger.Module

@Module
interface BCloudDataSourceMapperModule {

    // Dagger генерирует java.util.List а у меня котиновский List
    // Все работает mutable list
    @Binds
    fun bindLWorkerInfoResponseToWorkerInfoDataMapper(mapper: LWorkerInfoResponseToLDataMapperImpl)
            : Base.Mapper<@JvmSuppressWildcards MutableList<WorkerInfoResponse>, WorkersInfoStateDataModel>

    @Binds
    fun bindWorkerInfoResponseToDataMapper(mapper: WorkerInfoResponseToDataMapper)
            : Base.Mapper<WorkerInfoResponse, WorkerInfoDataModel>
}