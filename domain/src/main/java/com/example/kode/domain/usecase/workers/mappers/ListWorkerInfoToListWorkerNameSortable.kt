package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkerNameSortableEntity
import javax.inject.Inject

class ListWorkerInfoToListWorkerNameSortable @Inject constructor():
    Base.Mapper<List<@JvmSuppressWildcards WorkerInfoEntity>, List<@JvmSuppressWildcards WorkerNameSortableEntity>> {

    override fun map(model: List<WorkerInfoEntity>): List<WorkerNameSortableEntity> =
        model.map { workerInfoEntity ->
            with(workerInfoEntity) {
                WorkerNameSortableEntity(id, avatarUrl, name, lastName, userTag, position)
            }
        }
}