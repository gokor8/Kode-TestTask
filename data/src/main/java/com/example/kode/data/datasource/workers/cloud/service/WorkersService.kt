package com.example.kode.data.datasource.workers.cloud.service

import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse

interface WorkersService {

    fun getWorkers(): WorkersResponse
}