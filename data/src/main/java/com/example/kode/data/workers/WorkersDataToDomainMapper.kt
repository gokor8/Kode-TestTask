package com.example.kode.data.workers

import com.example.kode.data.workers.model.WorkersDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersEntity

class WorkersDataToDomainMapper : Base.Mapper.Mapper<WorkersDataModel, WorkersEntity> {
    override fun map(model: WorkersDataModel): WorkersEntity = WorkersEntity.SuccessEntity(
        model.name,
        model.lastName,
        model.userTag,
        model.position
    )
}