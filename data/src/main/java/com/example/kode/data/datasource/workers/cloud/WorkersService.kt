package com.example.kode.data.datasource.workers.cloud

import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse

interface WorkersService {

    fun getWorkers(): WorkersResponse
}