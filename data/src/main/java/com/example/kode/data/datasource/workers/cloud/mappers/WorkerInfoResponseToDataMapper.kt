package com.example.kode.data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base

class WorkerInfoResponseToDataMapper : Base.Mapper<WorkerInfoResponse, WorkerInfoDataModel.Success> {
    override fun map(model: WorkerInfoResponse): WorkerInfoDataModel.Success = with(model) {
        WorkerInfoDataModel.Success(
            id,
            firstName,
            lastName,
            userTag,
            position,
            userTag,
            department,
            birthday,
            phone
        )
    }
}