package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

sealed class MainStatesUI {

    data class Success(
        val workers: List<WorkerInfoUIModel>
    ) : MainStatesUI()

    sealed class Fail {
        class Error : MainStatesUI()
        class NoConnection : MainStatesUI()
    }
}