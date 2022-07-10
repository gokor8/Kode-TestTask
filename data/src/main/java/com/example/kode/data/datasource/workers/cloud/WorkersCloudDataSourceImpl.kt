package com.example.kode.data.datasource.workers.cloud

import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse
import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.domain.core.Base

class WorkersCloudDataSourceImpl<R>(
    private val api: WorkersService,
    private val workersResponseMapper: Base.Mapper<WorkersResponse, R>
    ) : WorkersCloudDataSource<R> {

    override fun get(): R = api.getWorkers().map(workersResponseMapper)
}