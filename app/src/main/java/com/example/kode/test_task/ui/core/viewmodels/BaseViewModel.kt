package com.example.kode.test_task.ui.core.viewmodels

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kode.test_task.ui.core.BaseObserver
import com.example.kode.test_task.ui.core.communications.BaseCommunication
import com.example.kode.test_task.ui.core.communications.LiveDataCommunication

abstract class BaseViewModel<C : BaseObserver<M>, M>(
    protected val communication: C
) : ViewModel(), BaseObserver<M> {

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<M>) {
        communication.observe(lifecycleOwner, observer)
    }
}