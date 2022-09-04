package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import javax.inject.Inject

class WorkersCacheEntityToUIMapper @Inject constructor(
    private val mapper: Base.Mapper<WorkerInfoEntity, WorkerInfoUIModel>
) : Base.Mapper<WorkersStateEntity.NoConnection, MainStatesUI.Success.Cache> {

    override fun map(model: WorkersStateEntity.NoConnection) = MainStatesUI.Success.Cache(
        model.workers.map { it.map(mapper) }
    )

}