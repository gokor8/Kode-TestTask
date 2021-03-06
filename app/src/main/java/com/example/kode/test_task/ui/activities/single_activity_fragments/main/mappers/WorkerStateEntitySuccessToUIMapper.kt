package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel

class WorkerStateEntitySuccessToUIMapper(
    private val mapper : Base.Mapper<WorkerInfoEntity, WorkerInfoUIModel>
) :
    Base.Mapper<WorkersStateEntity.Success, MainStatesUI.Success> {
    override fun map(model: WorkersStateEntity.Success): MainStatesUI.Success =
        MainStatesUI.Success(
            model.workers.map { it.map(mapper) }
        )
}