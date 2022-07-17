package com.example.kode.data.datasource.workers.cloud.service

import com.example.kode.data.datasource.workers.cloud.api.WorkersApi
import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse

class WorkersServiceImpl(private val api: WorkersApi) : WorkersService<WorkersResponse> {

    override fun getWorkers(): WorkersResponse = api.getWorkers()
}