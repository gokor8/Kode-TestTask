package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity
import com.example.kode.domain.entity.workers.sort.name.WorkerNameSortableEntity
import javax.inject.Inject

class ListWorkerNameSortableToListWorkerInfo @Inject constructor():
    Base.Mapper<List<@JvmSuppressWildcards WorkerStringSortableEntity>, List<@JvmSuppressWildcards WorkerInfoEntity>> {

    override fun map(model: List<WorkerStringSortableEntity>): List<WorkerInfoEntity> =
        model.map { workerNameSortableEntity ->
            with(workerNameSortableEntity) {
                WorkerInfoEntity(id, avatarUrl, name, lastName, userTag, position)
            }
        }
}