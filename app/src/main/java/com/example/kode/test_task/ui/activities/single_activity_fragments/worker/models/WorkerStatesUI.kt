package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models

sealed interface WorkerStatesUI {

    class Success(
        val avatarUrl: String,
        val firstName: String,
        val lastName: String,
        val userTag: String,
        val department: String,
        val position: String,
        val birthday: String,
        val age: String,
        val phone: String,
    ) : WorkerStatesUI

    class FatalError : WorkerStatesUI
}