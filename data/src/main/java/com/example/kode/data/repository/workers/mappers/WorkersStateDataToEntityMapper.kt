package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersEntity

// Если появится другое состояние, то будет легко добавить его сюда и написать к нему маппер
class WorkersStateDataToEntityMapper(
    private val successMapper: Base.Mapper<WorkersDataModel.Success, WorkersEntity.SuccessEntity>
) :
    Base.Mapper<WorkersDataModel, WorkersEntity> {
    override fun map(model: WorkersDataModel): WorkersEntity =
        when (model) {
            is WorkersDataModel.Success -> successMapper.map(model)
        }
}