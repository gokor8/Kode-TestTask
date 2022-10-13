package com.example.kode.data.repository.worker.mappers

import com.example.kode.data.datasource.workers.cache.exceptions.NoCacheException
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import javax.inject.Inject

class ExceptionToFailWorkerFullMapper @Inject constructor() : Base.Mapper<Exception, WorkerFullStateEntity> {
    override fun map(model: Exception) = when (model) {
        is NoCacheException -> WorkerFullStateEntity.Fail(Exceptions.NoCacheException)
        else -> WorkerFullStateEntity.Fail(Exceptions.GenericException)
    }
}