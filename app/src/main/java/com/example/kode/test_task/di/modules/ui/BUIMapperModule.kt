package com.example.kode.test_task.di.modules.ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.WorkerInfoEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.WorkerStateEntityFailToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.WorkerStateEntitySuccessToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.WorkersStateEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import dagger.Binds
import dagger.Module

@Module
abstract class BUIMapperModule {

    @Binds
    abstract fun bindWorkerStateEntityToUIMapper(mapper: WorkersStateEntityToUIMapper)
            : Base.Mapper<WorkersStateEntity, MainStatesUI>

    @Binds
    abstract fun bindWorkerStateEntitySuccessToUIMapper(successToUIMapper: WorkerStateEntitySuccessToUIMapper)
            : Base.Mapper<WorkersStateEntity.Success, MainStatesUI.Success>

    @Binds
    abstract fun bindWorkerStateEntityFailToUIMapper(failToUIMapper: WorkerStateEntityFailToUIMapper)
            : Base.Mapper<WorkersStateEntity.Fail, MainStatesUI.Fail>

/*    @Binds
    abstract fun bindWorkerInfoEntityToUIMapper(workerStateEntityFailToUIMapper: WorkerInfoEntityToUIMapper)
            : Base.Mapper<WorkerInfoEntity, WorkerInfoUIModel>*/
}