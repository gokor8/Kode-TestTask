package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity

// Если появится другое состояние, то будет легко добавить его сюда и написать к нему маппер
class WorkersStateDataToEntityMapper(
    private val successMapper: Base.Mapper<WorkersInfoStateDataModel.Success, WorkersStateEntity.Success>
) :
    Base.Mapper<WorkersInfoStateDataModel, WorkersStateEntity> {
    override fun map(model: WorkersInfoStateDataModel): WorkersStateEntity =
        when (model) {
            is WorkersInfoStateDataModel.Success -> successMapper.map(model)
        }
}