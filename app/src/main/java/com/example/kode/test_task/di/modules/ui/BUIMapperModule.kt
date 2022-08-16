package com.example.kode.test_task.di.modules.ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.*
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import dagger.Binds
import dagger.Module

@Module
interface BUIMapperModule {

    @Binds
    fun bindWorkerStateEntityToUIMapper(mapper: WorkersStateEntityToUIMapper)
            : Base.Mapper<WorkersStateEntity, MainStatesUI>

    @Binds
    fun bindWorkerStateEntitySuccessToUIMapper(successToUIMapper: WorkerStateEntitySuccessToUIMapper)
            : Base.Mapper<WorkersStateEntity.Success, MainStatesUI.Success>

    @Binds
    fun bindWorkerStateEntityNoConnectionToUIMapper(noConnectionMapper: WorkerStateEntityNoConnectionToUIMapper)
            : Base.Mapper<WorkersStateEntity.NoConnection, MainStatesUI.NoConnection>

    @Binds
    fun bindWorkerStateEntityFailToUIMapper(failToUIMapper: WorkerStateEntityFailToUIMapper)
            : Base.Mapper<WorkersStateEntity.Fail, MainStatesUI.Fail>

    @Binds
    fun bindWorkerInfoEntityToUIMapper(workerStateEntityFailToUIMapper: WorkerInfoEntityToUIMapper)
            : Base.Mapper<WorkerInfoEntity, WorkerInfoUIModel>
}