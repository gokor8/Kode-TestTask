package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity

// Если появится другое состояние, то будет легко добавить его сюда и написать к нему маппер
class WorkersStateDataToEntityMapper(
    private val successMapper: Base.Mapper<WorkerInfoDataModel.Success, WorkersStateEntity.Success>
) :
    Base.Mapper<WorkerInfoDataModel, WorkersStateEntity> {
    override fun map(model: WorkerInfoDataModel): WorkersStateEntity =
        when (model) {
            is WorkerInfoDataModel.Success -> successMapper.map(model)
        }
}