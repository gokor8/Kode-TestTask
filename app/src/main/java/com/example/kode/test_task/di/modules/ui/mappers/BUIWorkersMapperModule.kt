package com.example.kode.test_task.di.modules.ui.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.*
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import dagger.Binds
import dagger.Module

@Module
interface BUIWorkersMapperModule {

    @Binds
    fun bindWorkerStateEntityToUIMapper(mapper: WorkersStateEntityToUIMapper)
            : Base.Mapper<WorkersStateEntity, MainStatesUI>

    @Binds
    fun bindWorkerStateEntitySuccessToUIMapper(successToUIMapper: WorkersCloudEntityToUIMapper)
            : Base.Mapper<WorkersStateEntity.Success, MainStatesUI.Success.Cloud>

    @Binds
    fun bindWorkersCacheEntityToUIMapper(noConnectionMapper: WorkersCacheEntityToUIMapper)
            : Base.Mapper<WorkersStateEntity.NoConnection, MainStatesUI.Success.Cache>

    @Binds
    fun bindWorkerStateEntityFailToUIMapper(failToUIMapper: WorkersFailEntityToUIMapper)
            : Base.Mapper<WorkersStateEntity.Fail, MainStatesUI.Fail>

    @Binds
    fun bindWorkerInfoEntityToUIMapper(workerStateEntityFailToUIMapper: WorkerInfoEntityToUIMapper)
            : Base.Mapper<WorkerInfoEntity, PreviewWorkerInfoUIModel>
}