package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerInputEntity
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import javax.inject.Inject

class UIToDomainMapper @Inject constructor() : Base.Mapper<WorkerInputEntity, WorkerInputEntity> {
    override fun map(model: WorkerInputEntity) = model
}