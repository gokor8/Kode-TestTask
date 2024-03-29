package com.example.kode.data.datasource.workers.cloud.service

import com.example.kode.data.datasource.workers.cloud.api.WorkersApi
import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse
import com.example.kode.domain.core.Base
import javax.inject.Inject

class WorkersServiceImpl @Inject constructor(
    private val api: WorkersApi,
) : WorkersService<WorkersResponse> {

    override suspend fun getWorkers(): WorkersResponse = api.getWorkers()
}