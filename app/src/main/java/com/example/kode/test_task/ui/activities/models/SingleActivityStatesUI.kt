package com.example.kode.test_task.ui.activities.models

sealed interface SingleActivityStatesUI {

    class Search(val searchText: String) : SingleActivityStatesUI

    class Cancel() : SingleActivityStatesUI
}