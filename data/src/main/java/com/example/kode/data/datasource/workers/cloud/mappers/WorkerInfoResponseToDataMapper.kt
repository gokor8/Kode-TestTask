package com.example.kode.data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base

class WorkerInfoResponseToDataMapper : Base.Mapper<WorkerInfoResponse, WorkerInfoDataModel> {
    override fun map(model: WorkerInfoResponse): WorkerInfoDataModel = with(model) {
        WorkerInfoDataModel(
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