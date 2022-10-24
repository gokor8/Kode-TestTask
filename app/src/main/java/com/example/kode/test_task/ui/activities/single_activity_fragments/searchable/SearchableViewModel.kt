package com.example.kode.test_task.ui.activities.single_activity_fragments.searchable

import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.communications.SearchableObserver
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.UISearchInputState
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.SearchResultStatesUI

interface SearchableViewModel<IM : UISearchInputState, M> : SearchableObserver<M> {

    fun search(searchState: IM)
}