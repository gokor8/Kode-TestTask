package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.core.usecase.UseCaseSuspend
import kotlin.coroutines.CoroutineContext

abstract class GetWorkersUseCase<M : UseCaseModel<M>>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, M>
) : UseCaseSuspend.UseCaseWithoutInput<M>(coroutineContext, failMapper)