package com.example.kode.domain.core.sort

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.core.usecase.UseCaseSuspend
import kotlin.coroutines.CoroutineContext

abstract class AbstractSortUseCase<I : SortModel, R : UseCaseModel<R>>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, R>
) : UseCaseSuspend.UseCaseWithInput<I, R>(coroutineContext, failMapper), SortUseCase<I, R>