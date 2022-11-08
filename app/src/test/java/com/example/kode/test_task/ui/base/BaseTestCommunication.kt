package com.example.kode.test_task.ui.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.core.communications.BaseCommunication

abstract class BaseTestCommunication<M> : BaseCommunication<M> {

    abstract var state: MutableList<M>

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {}

    override fun get() = state.last()

    override fun save(model: M) {
        state.add(model)
    }

}