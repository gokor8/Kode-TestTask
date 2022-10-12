package com.example.kode.test_task.di.modules.data

import com.example.kode.data.repository.worker.mappers.WorkerUseCaseToDataSourceModelMapper
import com.example.kode.data.repository.worker.models.WorkerInputDataModel
import com.example.kode.data.repository.workers.mappers.WorkerInfoDataModelToDomainMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataCacheToEntityMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataCloudToEntityMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataToEntityMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerInputEntity
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import dagger.Binds
import dagger.Module

@Module
interface BMapperModule {

    @Binds
    fun bindWorkersStateDataToEntityMapper(mapper: WorkersStateDataToEntityMapper)
            : Base.Mapper<WorkersInfoStateDataModel, WorkersStateEntity>

    @Binds
    fun bindWorkersStateDataSuccessToEntityMapper(mapper: WorkersStateDataCloudToEntityMapper)
            : Base.Mapper<WorkersInfoStateDataModel.Cloud, WorkersStateEntity.Success>

    @Binds
    fun bindWorkersStateDataNoConnectionToEntityMapper(mapper: WorkersStateDataCacheToEntityMapper)
            : Base.Mapper<WorkersInfoStateDataModel.Cache, WorkersStateEntity.NoConnection>

    @Binds
    fun bindWorkerInputDataModelToDomainMapper(mapper: WorkerUseCaseToDataSourceModelMapper)
            : Base.Mapper<WorkerInputEntity, WorkerInputDataModel>

    @Binds
    fun bindWorkerInfoDataModelToDomainMapper(mapper: WorkerInfoDataModelToDomainMapper)
            : Base.Mapper<WorkerInfoDataModel, WorkerInfoEntity>
}