package com.example.kode.test_task.ui.core.search

import com.example.kode.test_task.ui.core.search.states.UISearchState

interface SearchCommunication<M : UISearchState> : ObserveSearch<M> {

    fun searchSave(model: M)

}