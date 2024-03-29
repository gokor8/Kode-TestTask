package com.example.kode.domain.entity.worker

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.core.usecase.UseCaseModel

sealed class WorkerFullStateEntity : UseCaseModel {

    class Success(
        val avatarUrl: String,
        val firstName: String,
        val lastName: String,
        val userTag: String,
        val department: String,
        val position: String,
        val birthday: List<String>,
        val phone: String
    ) : WorkerFullStateEntity()

    class Fail(val exception: UseCaseExceptions) : WorkerFullStateEntity()
}