package com.example.kode.domain.core

interface Provide<M> {

    fun<P : M> provide(): M
}