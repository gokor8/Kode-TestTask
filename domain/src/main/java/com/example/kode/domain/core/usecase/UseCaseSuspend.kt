package com.example.kode.domain.core.usecase

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Read
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

sealed class UseCaseSuspend<R : UseCaseModel>(
    protected val coroutineContext: CoroutineContext,
    protected val failMapper: Base.Mapper<Exception, R>
) {

    // Можно было бы юзануть coroutineExceptionHandler, но мне больше нравится использовать подход с try{}catch

    abstract class UseCaseWithInput<I : Any, R : UseCaseModel>(
        coroutineContext: CoroutineContext,
        failMapper: Base.Mapper<Exception, R>
    ) : UseCaseSuspend<R>(coroutineContext, failMapper), UseCaseInput<I, R> {

        override suspend fun get(equalsAttribute: I): R = withContext(coroutineContext) {
            try {
                withSafe(equalsAttribute)
            } catch (e: Exception) {
                e.printStackTrace()
                failMapper.map(e)
            }
        }

        protected abstract suspend fun withSafe(equalsAttribute: I): R

    }

    abstract class UseCaseWithoutInput<R : UseCaseModel>(
        coroutineContext: CoroutineContext,
        failMapper: Base.Mapper<Exception, R>
    ) : UseCaseSuspend<R>(coroutineContext, failMapper), Read.Abstract.Suspend<R> {

        override suspend fun get(): R = withContext(coroutineContext) {
            try {
                getSafely()
            } catch (e: Exception) {
                e.printStackTrace()
                failMapper.map(e)
            }
        }

        protected abstract suspend fun getSafely(): R

    }
}