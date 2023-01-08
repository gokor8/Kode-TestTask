package com.example.kode.test_task.ui.core.search.states

interface UISearchState {
    interface Skip : UISearchState
    interface Success : UISearchState
    interface Fail : UISearchState
}