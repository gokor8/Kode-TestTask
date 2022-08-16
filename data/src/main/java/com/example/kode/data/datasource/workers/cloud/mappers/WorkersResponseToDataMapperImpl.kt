package com.example.kode.data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import javax.inject.Inject

// Dagger генерирует java.util.List а у меня котиновский List
class WorkersResponseToDataMapperImpl @Inject constructor(
    private val mapper: Base.Mapper<WorkerInfoResponse, WorkerInfoDataModel>
) : Base.Mapper<WorkersResponse, WorkersInfoStateDataModel> {
    override fun map(model: WorkersResponse): WorkersInfoStateDataModel =
        WorkersInfoStateDataModel.Cloud(model.items.map { it.map(mapper) }.toMutableList())
}
