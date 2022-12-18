package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.WorkersNameSortableStateEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

class WorkersStateToWorkersNameSortableState @Inject constructor(
    private val mapper: Base.Mapper<List<WorkerInfoEntity>, List<WorkerNameSortableEntity>>
) : Base.Mapper<WorkersStateEntity.WithConnection, WorkersNameSortableStateEntity> {

    override fun map(model: WorkersStateEntity.WithConnection): WorkersNameSortableStateEntity = with(model) {
        WorkersNameSortableStateEntity(
            mapper.map(workers)
        )
    }
}