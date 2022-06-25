package com.example.kode.domain.core

interface Save<I, R> {

    fun save(model: I): R
}