package com.example.kode.data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

// Dagger генерирует java.util.List а у меня котиновский List
class LWorkerInfoResponseToLDataMapperImpl @Inject constructor(
    private val mapper: Base.Mapper<WorkerInfoResponse, WorkerInfoDataModel>
) : Base.Mapper<MutableList<WorkerInfoResponse>, WorkersInfoStateDataModel> {
    override fun map(model: MutableList<WorkerInfoResponse>): WorkersInfoStateDataModel =
        WorkersInfoStateDataModel.Success(model.map { it.map(mapper) })
}
