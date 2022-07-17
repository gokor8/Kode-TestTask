package com.example.kode.domain.core

sealed interface Save {

    interface Base<I, R> {
        fun save(model: I): R
    }

    interface Suspend<I, R> {
        suspend fun save(model: I): R
    }
}