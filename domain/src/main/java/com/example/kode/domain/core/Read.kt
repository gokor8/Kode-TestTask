package com.example.kode.domain.core

sealed interface Read<R> {

    interface Base<R> : Read<R> {
        fun get(): R
    }

    interface WithId<I, R> : Read<R> {
        fun read(id: I): R
    }
}