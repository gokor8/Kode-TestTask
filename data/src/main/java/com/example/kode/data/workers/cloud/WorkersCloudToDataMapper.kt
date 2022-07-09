package com.example.kode.data.workers.cloud

import com.example.kode.data.workers.model.WorkersDataModel
import com.example.kode.domain.core.Base

class WorkersCloudToDataMapper : Base.Mapper<WorkersResponse, WorkersDataModel> {
    override fun map(model: WorkersResponse): WorkersDataModel = WorkersDataModel.Success(
        model.firstName,
        model.lastName,
        model.userTag,
        model.position
    )
}