package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.custom_exceptions.NotFoundSearchException
import com.example.kode.domain.entity.workers.WorkerSortableEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

class WorkersSortableToWorkersMapper @Inject constructor():
    Base.Mapper<List<@JvmSuppressWildcards WorkerSortableEntity>, WorkersStateEntity> {

    override fun map(model: List<WorkerSortableEntity>) = if(model.isNotEmpty())
        WorkersStateEntity.Success(model)
    else
        WorkersStateEntity.Fail(NotFoundSearchException())
}