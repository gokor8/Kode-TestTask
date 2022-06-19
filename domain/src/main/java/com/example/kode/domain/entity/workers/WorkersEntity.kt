package com.example.kode.domain.entity.workers

import com.example.kode.domain.core.Exceptions

sealed class WorkersEntity {

    data class SuccessEntity(
        val name: String,
        val lastName: String,
        val userTag: String,
        val position: String
    ) : WorkersEntity()

    data class FailEntity(val title: String, val Description: String) : WorkersEntity()

    data class ExceptionEntity(val exception: Exceptions): WorkersEntity()
}
