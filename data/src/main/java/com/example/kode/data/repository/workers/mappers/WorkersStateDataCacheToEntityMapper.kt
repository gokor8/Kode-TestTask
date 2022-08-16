package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

class WorkersStateDataCacheToEntityMapper @Inject constructor(
    private val mapper: Base.Mapper<WorkerInfoDataModel, WorkerInfoEntity>
) : Base.Mapper<WorkersInfoStateDataModel.Cache, WorkersStateEntity.NoConnection> {

    override fun map(model: WorkersInfoStateDataModel.Cache): WorkersStateEntity.NoConnection =
        WorkersStateEntity.NoConnection(model.workers.map { it.map(mapper) })

}