package com.example.kode.domain.core

sealed class Exceptions {
    class GenericException : Exceptions()
    class NoConnection() : Exceptions()
}