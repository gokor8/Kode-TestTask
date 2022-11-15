package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

class WorkersToSortableMapper @Inject constructor() : Base.Mapper<WorkersStateEntity, List<@JvmSuppressWildcards WorkerInfoEntity>> {
    override fun map(model: WorkersStateEntity): List<WorkerInfoEntity> = when(model) {
        is WorkersStateEntity.Success -> model.workers
        is WorkersStateEntity.NoConnection -> model.workers
        is WorkersStateEntity.Fail -> emptyList()
    }
}