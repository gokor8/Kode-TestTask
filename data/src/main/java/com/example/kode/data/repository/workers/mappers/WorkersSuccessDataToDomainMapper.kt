package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity

class WorkersSuccessDataToDomainMapper :
    Base.Mapper<WorkersDataModel.Success, WorkersStateEntity.SuccessEntity> {
    override fun map(model: WorkersDataModel.Success): WorkersStateEntity.SuccessEntity =
        WorkersStateEntity.SuccessEntity(
            model.name,
            model.lastName,
            model.userTag,
            model.position
        )
}