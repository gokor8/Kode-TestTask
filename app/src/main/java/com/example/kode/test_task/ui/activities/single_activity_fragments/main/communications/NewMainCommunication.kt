package com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.temp_searchable.UISearchState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.LiveDataCommunication
import javax.inject.Inject

class NewMainCommunication @Inject constructor() : MainCommunication<MainStatesUI> {

    private val baseCommunication = LiveDataCommunication<MainStatesUI>()
    private val searchCommunication = LiveDataCommunication<UISearchState>()

    override fun searchSave(model: UISearchState) {
        searchCommunication.save(model)
    }

    override fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<UISearchState>) {
        searchCommunication.observe(lifecycleOwner, observer)
    }

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<MainStatesUI>) {
        baseCommunication.observe(lifecycleOwner, observer)
    }

    override fun save(model: MainStatesUI) {
        baseCommunication.save(model)
    }

    override fun get() = baseCommunication.get()

    override fun notifyIt() {
        baseCommunication.get()?.let(baseCommunication::save)
    }

    override fun isEmpty() = baseCommunication.get() == null

    override fun isNotEmpty() = baseCommunication.get() != null

}