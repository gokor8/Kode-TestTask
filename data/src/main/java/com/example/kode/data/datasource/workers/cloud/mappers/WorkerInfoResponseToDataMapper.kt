package com.example.kode.data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

class WorkerInfoResponseToDataMapper @Inject constructor() : Base.Mapper<WorkerInfoResponse, WorkerInfoDataModel> {
    override fun map(model: WorkerInfoResponse): WorkerInfoDataModel = with(model) {
        WorkerInfoDataModel(
            id,
            avatarUrl,
            firstName,
            lastName,
            userTag,
            department,
            position,
            listOf(birthday),
            phone
        )
    }
}