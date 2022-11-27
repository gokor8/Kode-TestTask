package com.example.kode.domain.usecase.worker

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.core.usecase.UseCaseSuspend
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

abstract class GetWorkerUseCase<IM : UseCaseModel, M : UseCaseModel> (
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, M>,
) : UseCaseSuspend.UseCaseWithInput<IM, M>(coroutineContext, failMapper)