package com.example.kode.test_task.ui.core

sealed class TestUIStates {

    class Success(val id: String) : TestUIStates()
    class Fail(val error: String) : TestUIStates()
    class NoConnection(val id: String) : TestUIStates()
}