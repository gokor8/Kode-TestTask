package com.example.kode.test_task.ui.core.view_model

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kode.test_task.ui.core.BaseObserver

abstract class BaseViewModel<C : BaseObserver<M>, M : Any>(
) : ViewModel(), BaseObserver<M> {

    protected abstract val communication: C

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {
        communication.observe(lifecycleOwner, observer)
    }
}