package com.example.kode.test_task.di.modules.domain

import com.example.kode.data.repository.worker.mappers.ExceptionToFailWorkerFullMapper
import com.example.kode.data.repository.workers.mappers.ExceptionToFailEntityMapper
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkerSortableEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.workers.mappers.WorkersSortableToWorkersMapper
import com.example.kode.domain.usecase.workers.mappers.WorkersToSortableMapper
import dagger.Binds
import dagger.Module

@Module
interface BMapperModule {

    @Binds
    fun bindExceptionToFailEntityMapper(mapper: ExceptionToFailEntityMapper)
            : Base.Mapper<Exception, WorkersStateEntity>

    @Binds
    fun bindExceptionToFailWorkerFullEntityMapper(mapper: ExceptionToFailWorkerFullMapper)
            : Base.Mapper<Exception, WorkerFullStateEntity>

    @Binds
    fun bindWorkersSortableToWorkersMapper(mapper: WorkersSortableToWorkersMapper)
            : Base.Mapper<List<@JvmSuppressWildcards WorkerSortableEntity>, WorkersStateEntity>

    @Binds
    fun bindWorkersToSortableMapper(mapper: WorkersToSortableMapper)
            : Base.Mapper<WorkersStateEntity, List<WorkerInfoEntity>>
}