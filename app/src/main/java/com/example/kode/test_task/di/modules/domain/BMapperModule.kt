package com.example.kode.test_task.di.modules.domain

import com.example.kode.data.repository.worker.mappers.ExceptionToFailWorkerFullMapper
import com.example.kode.data.repository.workers.mappers.ExceptionToFailEntityMapper
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui.WorkerFullInfoStateTUIMapper
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
}
