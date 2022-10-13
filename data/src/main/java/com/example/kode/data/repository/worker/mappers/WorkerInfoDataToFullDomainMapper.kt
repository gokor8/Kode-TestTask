package com.example.kode.data.repository.worker.mappers

import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import javax.inject.Inject

class WorkerInfoDataToFullDomainMapper @Inject constructor() :
    Base.Mapper<WorkerInfoDataModel, WorkerFullStateEntity> {
    override fun map(model: WorkerInfoDataModel): WorkerFullStateEntity =
        with(model) {
            WorkerFullStateEntity.Success(
                avatarUrl,
                firstName,
                lastName,
                userTag,
                department,
                position,
                birthday,
                phone
            )
        }
}