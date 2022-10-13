package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import javax.inject.Inject

class WorkerFullInfoStateTUIMapper @Inject constructor(
    private val failMapper: Base.Mapper<WorkerFullStateEntity.Fail, WorkerStatesUI.Fail>,
    private val successMapper: Base.Mapper<WorkerFullStateEntity.Success, WorkerStatesUI.Success>
) : Base.Mapper<WorkerFullStateEntity, WorkerStatesUI> {
    override fun map(model: WorkerFullStateEntity): WorkerStatesUI = when(model) {
        is WorkerFullStateEntity.Success -> successMapper.map(model)
        is WorkerFullStateEntity.Fail -> failMapper.map(model)
    }
}