package com.example.kode.data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base

class LWorkerInfoResponseToLDataMapper(
    private val mapper: Base.Mapper<WorkerInfoResponse, WorkerInfoDataModel>
) : Base.Mapper<List<WorkerInfoResponse>, WorkersInfoStateDataModel.Success> {
    override fun map(model: List<WorkerInfoResponse>): WorkersInfoStateDataModel.Success =
        WorkersInfoStateDataModel.Success(model.map { it.map(mapper) })
}
