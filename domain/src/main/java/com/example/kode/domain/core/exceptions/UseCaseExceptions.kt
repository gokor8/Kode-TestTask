package com.example.kode.domain.core.exceptions

interface UseCaseExceptions {
    object GenericException : UseCaseExceptions
    object NoCacheException : UseCaseExceptions
}