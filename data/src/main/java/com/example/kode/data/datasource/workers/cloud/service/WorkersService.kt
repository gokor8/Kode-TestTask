package com.example.kode.data.datasource.workers.cloud.service

interface WorkersService<R : Any> {

    suspend fun getWorkers(): R
}