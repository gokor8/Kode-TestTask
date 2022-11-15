package com.example.kode.domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.FilterableCreator
import com.example.kode.domain.core.sort.SortUseCaseModel
import com.example.kode.domain.core.sort.SortableUseCaseModel
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.core.usecase.UseCaseSuspend
import kotlin.coroutines.CoroutineContext

abstract class GetWorkersUseCase<M : UseCaseModel, SM>(
    coroutineContext: CoroutineContext,
    failMapper: Base.Mapper<Exception, M>
) : UseCaseSuspend.UseCaseWithInput<SM?, M>(coroutineContext, failMapper)