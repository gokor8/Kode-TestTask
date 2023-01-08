package com.example.kode.test_task.ui.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.core.communications.AbstractCommunication

class TestCommunication<M : Any>(baseListValue: MutableList<M>? = null) : AbstractCommunication<M, List<M>>()  {

    override val communicationModel: MutableList<M>

    init {
        communicationModel = baseListValue ?: mutableListOf()
    }

    fun get() = communicationModel.last()

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {}

    override fun save(model: M) {
        communicationModel.add(model)
    }
}