package com.example.kode.domain.usecase.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity
import com.example.kode.domain.entity.workers.sort.WorkersCacheSortableStateEntity
import com.example.kode.domain.entity.workers.sort.WorkersCloudSortableStateEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import javax.inject.Inject

class WorkersSortableStateToWorkersState @Inject constructor(
    private val mapper: Base.Mapper<
            List<@JvmSuppressWildcards WorkerStringSortableEntity>,
            List<@JvmSuppressWildcards WorkerInfoEntity>
            >,
) : Base.Mapper<WorkersSortableStateEntity, WorkersStateEntity> {

    override fun map(model: WorkersSortableStateEntity): WorkersStateEntity {
        val sortableList = mapper.map(model.getSortableList())

        return when (model) {
            is WorkersCloudSortableStateEntity -> WorkersStateEntity.WithConnection(sortableList)
            is WorkersCacheSortableStateEntity -> WorkersStateEntity.NoConnection(sortableList)
        }
    }
}
