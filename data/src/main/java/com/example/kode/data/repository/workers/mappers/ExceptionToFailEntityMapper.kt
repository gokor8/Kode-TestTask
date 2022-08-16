package com.example.kode.data.repository.workers.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.custom_exceptions.GenericException
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import javax.inject.Inject

class ExceptionToFailEntityMapper @Inject constructor() : Base.Mapper<Exception, WorkersStateEntity> {
    override fun map(model: Exception) = when (model) {
        //is GenericException -> WorkersStateEntity.Fail(Exceptions.GenericException)
        else -> WorkersStateEntity.Fail(Exceptions.GenericException)
    }
}