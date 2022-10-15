package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import javax.inject.Inject

class WorkerInfoEntityToUIMapper @Inject constructor() : Base.Mapper<WorkerInfoEntity, PreviewWorkerInfoUIModel> {
    override fun map(model: WorkerInfoEntity): PreviewWorkerInfoUIModel = with(model) {
        PreviewWorkerInfoUIModel(
            id, avatarUrl, name, lastName, userTag, position
        )
    }
}