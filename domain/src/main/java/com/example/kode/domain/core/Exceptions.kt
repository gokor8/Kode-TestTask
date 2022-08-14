package com.example.kode.domain.core

sealed class Exceptions {
    object GenericException : Exceptions()
    object NoConnection : Exceptions()
}