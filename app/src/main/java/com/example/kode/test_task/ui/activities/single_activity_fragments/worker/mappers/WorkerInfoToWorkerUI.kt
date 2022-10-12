package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import javax.inject.Inject

class WorkerInfoToWorkerUI @Inject constructor() : Base.Mapper<WorkerInfoEntity, WorkerStatesUI> {
    override fun map(model: WorkerInfoEntity) = WorkerStatesUI.Success(model)
}