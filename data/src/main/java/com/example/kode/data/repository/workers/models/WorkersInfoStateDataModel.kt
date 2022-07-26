package com.example.kode.data.repository.workers.models

sealed class WorkersInfoStateDataModel {

    data class Success(
        val workers: List<WorkerInfoDataModel>
    ) : WorkersInfoStateDataModel()
}
