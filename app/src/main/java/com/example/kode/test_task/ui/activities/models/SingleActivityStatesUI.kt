package com.example.kode.test_task.ui.activities.models

sealed class SingleActivityStatesUI {

    class Search(val searchText: String)

    class Cancel()
}