package com.example.kode.test_task.ui.core.communications

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

// Will be good if we needing postValue realization and value
abstract class LiveDataCommunication<M : Any> : AbstractCommunication<MutableLiveData<M>, M>() {

    override val savedValue = MutableLiveData<M>()

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {
        savedValue.observe(lifecycleOwner, observer)
    }

    override fun get(): M = savedValue.value!!

    override fun save(model: M) {
        savedValue.value = model
    }
}