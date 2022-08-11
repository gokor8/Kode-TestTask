package com.example.kode.test_task.di.modules.ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.WorkerInfoEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import dagger.Module
import dagger.Provides

@Module
class PUIMapperModule {

    @Provides
    fun provideWorkerInfoEntityToUIMapper(): Base.Mapper<WorkerInfoEntity, WorkerInfoUIModel> =
        WorkerInfoEntityToUIMapper()
}