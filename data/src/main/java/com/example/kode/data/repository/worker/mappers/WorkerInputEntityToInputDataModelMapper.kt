package com.example.kode.data.repository.worker.mappers

import com.example.kode.data.repository.worker.models.WorkerInputDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerInputEntity
import javax.inject.Inject

class WorkerInputEntityToInputDataModelMapper @Inject constructor() :
    Base.Mapper<WorkerInputEntity, WorkerInputDataModel> {
    override fun map(model: WorkerInputEntity) = WorkerInputDataModel(model.id)
}