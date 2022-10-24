package com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models

sealed class UISearchInputState {

    class Search(val text: String) : UISearchInputState()

    class Cancel() : UISearchInputState()
}