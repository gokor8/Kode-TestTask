package com.example.kode.data.datasource.workers.cloud.api

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface WorkersApi {

    @Headers("Content-Type: application/json")
    @GET("users")
    suspend fun getWorkers(): WorkersResponse
}