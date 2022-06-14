package com.example.kode.domain.core

sealed interface BaseState {

    interface Success : BaseState

    interface Fail : BaseState
}