package com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.communications

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.SearchResultStatesUI
import com.example.kode.test_task.ui.core.communications.BaseCommunication
import javax.inject.Inject

class SearchableCommunication<BM, SM : SearchResultStatesUI> @Inject constructor(
    private val baseCommunication: BaseCommunication<BM>,
    private val searchCommunication: BaseCommunication<SM>
) : BaseCommunication<BM>, SearchableObserver<SM>, SearchableSave<SM> {

    override fun get(): BM = baseCommunication.get()

    override fun save(model: BM) = baseCommunication.save(model)

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<BM>) {
        baseCommunication.observe(lifecycleOwner, observer)
    }

    override fun saveSearch(saveModel: SM) = searchCommunication.save(saveModel)

    override fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<SM>) {
        searchCommunication.observe(lifecycleOwner, observer)
    }
}