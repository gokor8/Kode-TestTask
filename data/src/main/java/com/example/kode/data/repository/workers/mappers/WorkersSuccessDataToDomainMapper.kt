package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity

class WorkersSuccessDataToDomainMapper :
    Base.Mapper<WorkerInfoDataModel.Success, WorkersStateEntity.Success> {
    override fun map(model: WorkerInfoDataModel.Success): WorkersStateEntity.Success =
        with(model) {
            WorkersStateEntity.Success(
                avatarUrl,
                firstName,
                lastName,
                userTag,
                position
            )
        }
}