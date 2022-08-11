package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

class WorkerInfoDataModelToDomainMapper @Inject constructor() :
    Base.Mapper<WorkerInfoDataModel, WorkerInfoEntity> {
    override fun map(model: WorkerInfoDataModel): WorkerInfoEntity =
        with(model) {
            WorkerInfoEntity(
                avatarUrl,
                firstName,
                lastName,
                userTag,
                position
            )
        }
}