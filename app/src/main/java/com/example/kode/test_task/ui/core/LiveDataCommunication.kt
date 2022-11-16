package com.example.kode.test_task.ui.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.kode.domain.core.Save

// Will be good if we needing postValue realization and value
abstract class LiveDataCommunication<M : Any> : BaseObserver<M>, Save.Base<M, Unit> {

    protected val liveData = MutableLiveData<M>()

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {
        liveData.observe(lifecycleOwner, observer)
    }

    override fun save(model: M) {
        liveData.value = model
    }
}