package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

class WorkersInfoListToWorkersState @Inject constructor() : Base.Mapper<List<@JvmSuppressWildcards WorkerInfoEntity>, WorkersStateEntity> {
    override fun map(model: List<WorkerInfoEntity>) = WorkersStateEntity.Success(model)
}