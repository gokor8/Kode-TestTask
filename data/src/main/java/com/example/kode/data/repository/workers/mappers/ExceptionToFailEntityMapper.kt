package com.example.kode.data.repository.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.workers.WorkersEntity
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException

class ExceptionToFailEntityMapper : Base.Mapper<Exception, WorkersEntity.FailEntity> {
    override fun map(model: Exception) = when (model) {
        is NoConnectionException -> WorkersEntity.FailEntity(Exceptions.NO_CONNECTION_EXCEPTION)
        else -> WorkersEntity.FailEntity(Exceptions.GENERIC_EXCEPTION)
    }
}