package com.example.kode.domain.core

interface Base {

    interface Model

    interface Mapper<in I, out R> {
        fun map(model: I): R
    }

    interface FuncMapper {
        fun<I, R> map(model: I): R
    }

    interface IgnorantMapper<M> {
        fun<I : Mapper<M,R>, R> map(model: I): R
    }
}