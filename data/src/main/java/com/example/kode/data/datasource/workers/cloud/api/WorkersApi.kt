package com.example.kode.data.datasource.workers.cloud.api

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import retrofit2.http.GET

interface WorkersApi {

    @GET("users/")
    fun getWorkers(): MutableList<WorkerInfoResponse>
}