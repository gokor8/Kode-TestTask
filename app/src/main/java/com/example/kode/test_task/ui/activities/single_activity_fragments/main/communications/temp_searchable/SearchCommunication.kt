package com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.temp_searchable

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface SearchCommunication<M : UISearchState> {

    fun searchSave(model: M)

    fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<M>)
}