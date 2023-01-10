package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.entity.workers.sort.WorkersCacheSortableStateEntity
import com.example.kode.domain.entity.workers.sort.WorkersCloudSortableStateEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.domain.entity.workers.sort.name.WorkerNameSortableEntity
import javax.inject.Inject

class WorkersStateToWorkersNameSortableState @Inject constructor(
    private val mapper: Base.Mapper<List<WorkerInfoEntity>, List<WorkerNameSortableEntity>>,
) : Base.Mapper<WorkersStateEntity.Success, WorkersSortableStateEntity> {

    override fun map(model: WorkersStateEntity.Success): WorkersSortableStateEntity = with(model) {
        val workersList = mapper.map(workers)
        return@with when (model) {
            is WorkersStateEntity.WithConnection -> WorkersCloudSortableStateEntity(workersList)
            is WorkersStateEntity.NoConnection -> WorkersCacheSortableStateEntity(workersList)
        }
    }
}
