package com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.communications

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.core.communications.BaseCommunication
import javax.inject.Inject

class SearchableCommunicationImpl<M> @Inject constructor(
    private val baseCommunication: BaseCommunication<M>,
    private val searchCommunication: BaseCommunication<M>
) : SearchableCommunication<M> {

    override fun get(): M = baseCommunication.get()

    override fun save(model: M) = baseCommunication.save(model)

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {
        baseCommunication.observe(lifecycleOwner, observer)
    }

    override fun saveSearch(saveModel: M) = searchCommunication.save(saveModel)

    override fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {
        searchCommunication.observe(lifecycleOwner, observer)
    }
}