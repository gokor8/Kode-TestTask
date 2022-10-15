package com.example.kode.test_task.di.modules.ui.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.domain.entity.worker.WorkerInputEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.WorkerUIToDomainMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui.WorkerFailEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui.WorkerFullInfoStateTUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui.WorkerSuccessEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.UIStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.fail.UIFatalErrorMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import dagger.Binds
import dagger.Module

@Module
interface BUIWorkerMapperModule {

    @Binds
    fun bindWorkerUIToDomainMapper(workerUIToDomainMapper: WorkerUIToDomainMapper): Base.Mapper<String, WorkerInputEntity>

    @Binds
    fun bindWorkerFullInfoStateToUIMapper(workerFullInfoStateToUIMapper: WorkerFullInfoStateTUIMapper)
            : Base.Mapper<WorkerFullStateEntity, WorkerStatesUI>

    @Binds
    fun bindWorkerFailEntityToUIMapper(workerFullInfoStateToUIMapper: WorkerFailEntityToUIMapper)
            : Base.Mapper<WorkerFullStateEntity.Fail, WorkerStatesUI.FatalError>

    @Binds
    fun bindWorkerSuccessEntityToUIMapper(workerFullInfoStateToUIMapper: WorkerSuccessEntityToUIMapper)
            : Base.Mapper<WorkerFullStateEntity.Success, WorkerStatesUI.Success>
}