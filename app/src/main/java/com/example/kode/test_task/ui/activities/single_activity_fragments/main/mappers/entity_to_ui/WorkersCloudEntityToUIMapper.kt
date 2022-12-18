package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import javax.inject.Inject

class WorkersCloudEntityToUIMapper @Inject constructor(
    private val mapper: Base.Mapper<WorkerInfoEntity, PreviewWorkerInfoUIModel>
) :
    Base.Mapper<WorkersStateEntity.WithConnection, MainStatesUI.Success.Cloud> {

    override fun map(model: WorkersStateEntity.WithConnection) = MainStatesUI.Success.Cloud(
        model.workers.map { mapper.map(it) }
    )
}