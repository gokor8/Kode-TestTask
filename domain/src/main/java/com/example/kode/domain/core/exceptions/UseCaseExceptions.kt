package com.example.kode.domain.core.exceptions

abstract class UseCaseExceptions {
    object GenericException : UseCaseExceptions()
    object NoCacheException : UseCaseExceptions()
}