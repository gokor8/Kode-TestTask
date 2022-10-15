package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import javax.inject.Inject

class WorkerSuccessEntityToUIMapper @Inject constructor() :
    Base.Mapper<WorkerFullStateEntity.Success, WorkerStatesUI.Success> {
    override fun map(model: WorkerFullStateEntity.Success) = with(model) {
        WorkerStatesUI.Success(
            avatarUrl,
            firstName,
            lastName,
            userTag,
            department,
            position,
            birthday,
            "",
            phone
        )
    }
}