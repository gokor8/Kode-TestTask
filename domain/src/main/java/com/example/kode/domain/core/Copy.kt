package com.example.kode.domain.core

interface Copy<I : Any, R : Any> {

    fun copy(model: I): R
}