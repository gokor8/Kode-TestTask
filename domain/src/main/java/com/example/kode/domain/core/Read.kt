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

    sealed interface AbstractInput<R> : Read {
        interface BaseEqualable<I, R> : AbstractInput<R> {
            fun get(equalsAttribute: I): R
        }

        interface SuspendEquable<in I, R> : AbstractInput<R> {
            suspend fun get(equalsAttribute: I): R
        }
    }
}