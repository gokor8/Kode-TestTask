package com.example.kode.domain.core

interface ApplyAs<AS> {

    fun<T> T.applyAs(action: (AS) -> Unit): T {
        (this as? AS)?.apply(action::invoke)

        return this
    }
}