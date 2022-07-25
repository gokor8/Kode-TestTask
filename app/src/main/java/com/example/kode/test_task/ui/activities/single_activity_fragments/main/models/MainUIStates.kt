package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

sealed class MainUIStates {

    class Success : MainUIStates()
    class Fail : MainUIStates()
    class NoConnection : MainUIStates()
}