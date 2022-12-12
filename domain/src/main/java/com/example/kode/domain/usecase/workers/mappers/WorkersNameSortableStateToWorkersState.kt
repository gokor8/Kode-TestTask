package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.WorkersNameSortableStateEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

class WorkersNameSortableStateToWorkersState @Inject constructor(
    private val mapper: Base.Mapper<List<WorkerNameSortableEntity>, List<WorkerInfoEntity>>,
) : Base.Mapper<WorkersNameSortableStateEntity, WorkersStateEntity> {

    override fun map(model: WorkersNameSortableStateEntity) =
        WorkersStateEntity.Success(
            mapper.map(model.getSortableList())
        )
}