package com.example.kode.test_task.ui.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<C : BaseCommunication<M>, M : Any>(
    protected val communication: C
) : ViewModel() {

    fun observe(lifecycleOwner: LifecycleOwner, observer: (model: M) -> Unit) =
        communication.observe(lifecycleOwner, observer)
}