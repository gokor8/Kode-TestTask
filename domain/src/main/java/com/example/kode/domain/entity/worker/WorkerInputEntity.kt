package com.example.kode.domain.entity.worker

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel

class WorkerInputEntity(
    val id: String
) : UseCaseModel<WorkerInputEntity> {

    override fun <I : Base.Mapper<WorkerInputEntity, R>, R> map(model: I): R = model.map(this)
}