package com.example.kode.domain.core.exceptions

sealed class UseCaseExceptions {
    object GenericException : UseCaseExceptions()
    object NoCacheException : UseCaseExceptions()
}