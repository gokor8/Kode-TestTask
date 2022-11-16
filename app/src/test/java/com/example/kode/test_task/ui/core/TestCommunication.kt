package com.example.kode.test_task.ui.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class TestCommunication<M : Any>(baseListValue: MutableList<M>?) : AbstractCommunication<M, List<M>>()  {

    override val communicationModel: MutableList<M>

    init {
        communicationModel = baseListValue ?: mutableListOf()
    }


    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {}

    override fun save(model: M) {
        communicationModel.add(model)
    }
}