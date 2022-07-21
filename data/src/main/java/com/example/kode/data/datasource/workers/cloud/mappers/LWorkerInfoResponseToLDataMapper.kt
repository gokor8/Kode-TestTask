package com.example.kode.data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.core.Base

class LWorkerInfoResponseToLDataMapper(
    private val mapper: Base.Mapper<WorkerInfoResponse, WorkerInfoDataModel>
) : Base.Mapper<List<WorkerInfoResponse>, List<WorkerInfoDataModel>> {
    override fun map(model: List<WorkerInfoResponse>): List<WorkerInfoDataModel> =
        model.map { it.map(mapper) }
}
