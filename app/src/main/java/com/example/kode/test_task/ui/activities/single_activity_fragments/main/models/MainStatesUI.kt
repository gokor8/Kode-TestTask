package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import com.example.kode.test_task.R

sealed class MainStatesUI {

    data class Success(
        val workers: List<WorkerInfoUIModel>
    ) : MainStatesUI()

    data class NoConnection(
        val workers: List<WorkerInfoUIModel>
    ) : MainStatesUI()

    class Error(val errorId: Int) : MainStatesUI()
}