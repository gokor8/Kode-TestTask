package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import javax.inject.Inject

class WorkerInfoEntityToUIMapper @Inject constructor() : Base.Mapper<WorkerInfoEntity, WorkerInfoUIModel> {
   var count = 0
    override fun map(model: WorkerInfoEntity): WorkerInfoUIModel = with(model) {
        WorkerInfoUIModel(
            avatarUrl, name + ++count, lastName, userTag, position
        )
    }
}