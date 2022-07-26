package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity

class WorkersStateDataSuccessToEntityMapper(
    private val mapper: Base.Mapper<WorkerInfoDataModel, WorkerInfoEntity>
) :
    Base.Mapper<WorkersInfoStateDataModel.Success, WorkersStateEntity.Success> {
    override fun map(model: WorkersInfoStateDataModel.Success): WorkersStateEntity.Success =
        WorkersStateEntity.Success(
            model.workers.map { it.map(mapper) }
        )
}