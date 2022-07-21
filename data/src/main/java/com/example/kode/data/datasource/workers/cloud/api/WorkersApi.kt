package com.example.kode.data.datasource.workers.cloud.api

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse

interface WorkersApi {

    fun getWorkers(): List<WorkerInfoResponse>
}