package com.example.kode.data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse
import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.core.Base

class WorkersResponseToDataMapper : Base.Mapper<WorkersResponse, WorkersDataModel> {
    override fun map(model: WorkersResponse): WorkersDataModel = WorkersDataModel.Success(
        model.firstName,
        model.lastName,
        model.userTag,
        model.position
    )
}