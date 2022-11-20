package com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.temp_searchable

interface UISearchState {
    class Skip : UISearchState
    interface Success : UISearchState
    interface Fail : UISearchState
}