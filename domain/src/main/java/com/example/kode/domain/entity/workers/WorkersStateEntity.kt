package com.example.kode.domain.entity.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.core.usecase.UseCaseModel

sealed class WorkersStateEntity : UseCaseModel {

    data class Success(
        val workers: List<WorkerInfoEntity>
    ) : WorkersStateEntity()

    // Делаю NoConnection потому что логика отличается от обычной ошибки
    // Надо во первых список поставить из кеша, во вторых ошибку интернета у туллбара сделать
    data class NoConnection(
        val workers: List<WorkerInfoEntity>
    ) : WorkersStateEntity()

    data class Fail(val exception: UseCaseExceptions) : WorkersStateEntity()
}
