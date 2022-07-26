package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel

class WorkerInfoEntityToUIMapper : Base.Mapper<WorkerInfoEntity, WorkerInfoUIModel> {
    override fun map(model: WorkerInfoEntity): WorkerInfoUIModel = with(model) {
        WorkerInfoUIModel(
            avatarUrl, name, lastName, userTag, position
        )
    }
}