package com.example.kode.test_task.di.modules.ui.mappers

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.UIStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.fail.UIFatalErrorMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.load.UILoadMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import dagger.Binds
import dagger.Module

@Module
interface BUIWorkerStateMapperModule {
    @Binds
    fun bindWorkerUIStateMapper(workerUIStateMapper: UIStateMapper)
            : Base.Mapper<WorkerStatesUI, Unit>

    @Binds
    fun bindWorkerUISuccessMapper(workerUISuccessMapper: UISuccessMapper)
            : Base.Mapper<WorkerStatesUI.Success, Unit>

    @Binds
    fun bindWorkerUIFatalErrorMapper(workerUIFatalErrorMapper: UIFatalErrorMapper)
            : Base.Mapper<WorkerStatesUI.FatalError, Unit>

    @Binds
    fun bindWorkerUILoadMapper(workerUILoadMapper: UILoadMapper)
            : Base.Mapper<WorkerStatesUI.Load, Unit>
}