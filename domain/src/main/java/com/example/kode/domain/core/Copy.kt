package com.example.kode.domain.core

interface Copy<I : Any, R : Any> {

    fun copyByModel(model: I): R
}