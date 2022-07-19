package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity

// Если появится другое состояние, то будет легко добавить его сюда и написать к нему маппер
class WorkersStateDataToEntityMapper(
    private val successMapper: Base.Mapper<WorkersDataModel.Success, WorkersStateEntity.SuccessEntity>
) :
    Base.Mapper<WorkersDataModel, WorkersStateEntity> {
    override fun map(model: WorkersDataModel): WorkersStateEntity =
        when (model) {
            is WorkersDataModel.Success -> successMapper.map(model)
        }
}