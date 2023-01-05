package com.example.kode.domain.entity.workers

import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.core.sort.ToSortModel
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity

sealed class WorkersStateEntity : UseCaseModel {

    sealed class Success : WorkersStateEntity(), ToSortModel<WorkersSortableStateEntity> {
        abstract val workers: List<WorkerInfoEntity>
    }
    data class WithConnection(
        override val workers: List<WorkerInfoEntity>
    ) : Success()

    // Делаю NoConnection потому что логика отличается от обычной ошибки
    // Надо во первых список поставить из кеша, во вторых ошибку интернета у туллбара сделать
    data class NoConnection(
        override val workers: List<WorkerInfoEntity>
    ) : Success()

    data class Fail(val exception: UseCaseExceptions) : WorkersStateEntity()
}
