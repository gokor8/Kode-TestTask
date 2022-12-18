package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

// Если появится другое состояние, то будет легко добавить его сюда и написать к нему маппер
class WorkersStateDataToEntityMapper @Inject constructor(
    private val cloudMapper: Base.Mapper<WorkersInfoStateDataModel.Cloud, WorkersStateEntity.WithConnection>,
    private val cacheMapper: Base.Mapper<WorkersInfoStateDataModel.Cache, WorkersStateEntity.NoConnection>
) :
    Base.Mapper<WorkersInfoStateDataModel, WorkersStateEntity> {
    override fun map(model: WorkersInfoStateDataModel): WorkersStateEntity =
        when (model) {
            is WorkersInfoStateDataModel.Cloud -> cloudMapper.map(model)
            is WorkersInfoStateDataModel.Cache -> cacheMapper.map(model)
        }
}