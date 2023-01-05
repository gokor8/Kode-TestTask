package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.sort.name.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import javax.inject.Inject

class WorkersStateToWorkersNameSortableState @Inject constructor(
    private val mapper: Base.Mapper<List<WorkerInfoEntity>, List<WorkerNameSortableEntity>>
) : Base.Mapper<WorkersStateEntity.WithConnection, WorkersSortableStateEntity> {

    override fun map(model: WorkersStateEntity.WithConnection): WorkersSortableStateEntity = with(model) {
        WorkersSortableStateEntity(
            mapper.map(workers)
        )
    }
}
