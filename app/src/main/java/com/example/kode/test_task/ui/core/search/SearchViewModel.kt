package com.example.kode.test_task.ui.core.search

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MixSearchCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainCommunicationModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.search.states.UISearchState
import com.example.kode.test_task.ui.core.view_model.BaseViewModel

abstract class SearchViewModel<C : MixSearchCommunication<M, SM>, M : MainCommunicationModel, SM : UISearchState, IM : Any> :
    BaseViewModel<C, M>(), UISearch<IM>, ObserveSearch<SM> {

    override fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<SM>) {
        communication.observeSearch(lifecycleOwner, observer)
    }
}