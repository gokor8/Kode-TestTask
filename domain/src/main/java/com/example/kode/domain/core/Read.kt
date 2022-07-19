package com.example.kode.domain.core

sealed interface Read {

    sealed interface Abstract<R> : Read {
        interface Base<R> : Abstract<R> {
            fun get(): R
        }

        interface Suspend<R> : Abstract<R> {
            suspend fun get(): R
        }
    }

    sealed interface AbstractId<R> : Read {
        interface BaseEqualable<I, R> : AbstractId<R> {
            fun get(equalsAttribute: I): R
        }

        interface SuspendEqualable<I, R> : AbstractId<R> {
            suspend fun get(equalsAttribute: I): R
        }
    }
}