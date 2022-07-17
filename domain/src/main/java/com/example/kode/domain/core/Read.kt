package com.example.kode.domain.core

sealed interface Read<R> {

    interface Base<R> : Read<R> {
        fun get(): R
    }

    interface Suspend<R> : Read<R> {
        suspend fun get(): R
    }

    interface WithId<I, R> : Read<R> {
        fun read(id: I): R
    }

    interface SuspendWithId<I, R> : Read<R> {
        suspend fun read(id: I): R
    }
}