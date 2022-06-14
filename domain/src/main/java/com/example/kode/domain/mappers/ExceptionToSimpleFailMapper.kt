package com.example.kode.domain.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.exceptions.GenericException
import com.example.kode.domain.entity.fail.SimpleFail

class ExceptionToSimpleFailMapper(
    private val genericSimpleFail: SimpleFail,
    private val unknownSimpleFail: SimpleFail
) : Base.Mapper<Exception, SimpleFail> {
    override fun map(model: Exception): SimpleFail = when (model) {
        is GenericException -> genericSimpleFail
        else -> unknownSimpleFail
    }
}