package com.example.kode.data.workers.cloud

import com.example.kode.data.workers.model.WorkersDataModel

interface WorkersCloudDataSource {

    fun getWorkers() : WorkersResponse
}