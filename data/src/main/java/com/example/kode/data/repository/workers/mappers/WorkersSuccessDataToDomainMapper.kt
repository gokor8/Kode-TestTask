package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersEntity

class WorkersSuccessDataToDomainMapper :
    Base.Mapper<WorkersDataModel.Success, WorkersEntity.SuccessEntity> {
    override fun map(model: WorkersDataModel.Success): WorkersEntity.SuccessEntity =
        WorkersEntity.SuccessEntity(
            model.name,
            model.lastName,
            model.userTag,
            model.position
        )
}