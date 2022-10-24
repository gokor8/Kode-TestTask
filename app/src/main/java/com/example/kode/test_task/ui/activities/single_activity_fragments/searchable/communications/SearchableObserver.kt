package com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.communications

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.SearchResultStatesUI

interface SearchableObserver<M> {

    fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<M>)
}