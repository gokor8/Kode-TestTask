package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import javax.inject.Inject

class WorkerStateEntityNoConnectionToUIMapper @Inject constructor(
    private val mapper: Base.Mapper<WorkerInfoEntity, WorkerInfoUIModel>
) : Base.Mapper<WorkersStateEntity.NoConnection, MainStatesUI.NoConnection> {

    override fun map(model: WorkersStateEntity.NoConnection): MainStatesUI.NoConnection =
        MainStatesUI.NoConnection(
            model.workers.map { it.map(mapper) }
        )

}