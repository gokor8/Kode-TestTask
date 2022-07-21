package com.example.kode.data.datasource.workers.cloud.service

interface WorkersService<R : Any> {

    fun getWorkers(): R
}