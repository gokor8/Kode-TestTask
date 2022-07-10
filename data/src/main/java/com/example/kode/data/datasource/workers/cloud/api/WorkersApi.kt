package com.example.kode.data.datasource.workers.cloud.api

import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse

interface WorkersApi {

    fun getWorkers(): WorkersResponse
}