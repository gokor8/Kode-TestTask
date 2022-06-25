package com.example.kode.data.workers.cloud

import com.example.kode.data.workers.model.WorkersDataModel
import com.example.kode.domain.core.Base

class WorkersCloudToDataMapper : Base.Mapper.Mapper<WorkersResponse, WorkersDataModel> {
    override fun map(model: WorkersResponse): WorkersDataModel = WorkersDataModel(
        model.firstName,
        model.lastName,
        model.userTag,
        model.position
    )
}