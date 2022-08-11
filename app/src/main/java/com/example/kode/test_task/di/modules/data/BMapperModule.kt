package com.example.kode.test_task.di.modules.data

import com.example.kode.data.repository.workers.mappers.WorkerInfoDataModelToDomainMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataSuccessToEntityMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataToEntityMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import dagger.Binds
import dagger.Module

@Module
abstract class BMapperModule {

    @Binds
    abstract fun bindWorkersStateDataToEntityMapper(mapper: WorkersStateDataToEntityMapper)
            : Base.Mapper<WorkersInfoStateDataModel, WorkersStateEntity>

    @Binds
    abstract fun bindWorkersStateDataSuccessToEntityMapper(mapper: WorkersStateDataSuccessToEntityMapper)
            : Base.Mapper<WorkersInfoStateDataModel.Success, WorkersStateEntity.Success>

    @Binds
    abstract fun bindWorkerInfoDataModelToDomainMapper(mapper: WorkerInfoDataModelToDomainMapper)
            : Base.Mapper<WorkerInfoDataModel, WorkerInfoEntity>
}