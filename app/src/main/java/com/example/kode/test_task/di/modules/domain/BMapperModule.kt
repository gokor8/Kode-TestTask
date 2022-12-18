package com.example.kode.test_task.di.modules.domain

import com.example.kode.data.repository.worker.mappers.ExceptionToFailWorkerFullMapper
import com.example.kode.data.repository.workers.mappers.ExceptionToFailEntityMapper
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.WorkersNameSortableStateEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.workers.mappers.ListWorkerInfoToListWorkerNameSortable
import com.example.kode.domain.usecase.workers.mappers.ListWorkerNameSortableToListWorkerInfo
import com.example.kode.domain.usecase.workers.mappers.WorkersNameSortableStateToWorkersState
import com.example.kode.domain.usecase.workers.mappers.WorkersStateToWorkersNameSortableState
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
    fun bindWorkersStateEntitySuccessToNameSortable(mapper: ListWorkerNameSortableToListWorkerInfo)
            : Base.Mapper<List<WorkerNameSortableEntity>, List<WorkerInfoEntity>>

    @Binds
    fun bindWorkersNameSortableStateToWorkersState(mapper: WorkersNameSortableStateToWorkersState)
            : Base.Mapper<WorkersNameSortableStateEntity, WorkersStateEntity>

    @Binds
    fun bindWorkersStateToWorkersNameSortableState(mapper: WorkersStateToWorkersNameSortableState)
            : Base.Mapper<WorkersStateEntity.WithConnection, WorkersNameSortableStateEntity>

    @Binds
    fun bindListWorkerInfoToListWorkerNameSortable(mapper: ListWorkerInfoToListWorkerNameSortable)
            : Base.Mapper<List<WorkerInfoEntity>, List<WorkerNameSortableEntity>>
}
