package com.example.kode.domain.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.workers.WorkersEntity
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException

class ExceptionToExceptionEntityMapper : Base.Mapper<Exception, WorkersEntity.ExceptionEntity> {
    override fun map(model: Exception) = when (model) {
        is NoConnectionException -> WorkersEntity.ExceptionEntity(Exceptions.NO_CONNECTION_EXCEPTION)
        else -> WorkersEntity.ExceptionEntity(Exceptions.GENERIC_EXCEPTION)
    }
}