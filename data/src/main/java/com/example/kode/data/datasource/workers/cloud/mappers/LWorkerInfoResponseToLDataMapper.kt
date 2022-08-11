package com.example.kode.data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base

interface LWorkerInfoResponseToLDataMapper : Base.Mapper<List<WorkerInfoResponse>, WorkersInfoStateDataModel>