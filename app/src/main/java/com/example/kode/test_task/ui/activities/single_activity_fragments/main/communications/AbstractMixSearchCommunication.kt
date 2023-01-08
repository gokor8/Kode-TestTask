package com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainCommunicationModel
import com.example.kode.test_task.ui.core.communications.LiveDataCommunication
import com.example.kode.test_task.ui.core.search.states.UISearchState

abstract class AbstractMixSearchCommunication<BC : MainCommunicationModel, SC : UISearchState> :
    MixSearchCommunication<BC, SC> {

    protected val baseCommunication = LiveDataCommunication<BC>()
    protected val searchCommunication = LiveDataCommunication<SC>()

    override fun searchSave(model: SC) {
        searchCommunication.save(model)
    }

    override fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<SC>) {
        searchCommunication.observe(lifecycleOwner, observer)
    }

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<BC>) {
        baseCommunication.observe(lifecycleOwner, observer)
    }

    override fun save(model: BC) {
        baseCommunication.save(model)
    }

    override fun get() = baseCommunication.get()

    override fun notifyIt() {
        baseCommunication.get()?.let(baseCommunication::save)
    }

    override fun isEmpty() = baseCommunication.get() == null

    override fun isNotEmpty() = baseCommunication.get() != null

}