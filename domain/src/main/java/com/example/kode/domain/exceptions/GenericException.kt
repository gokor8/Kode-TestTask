package com.example.kode.domain.exceptions

import java.io.IOException

data class GenericException(
    val messageException: String
) : IOException()