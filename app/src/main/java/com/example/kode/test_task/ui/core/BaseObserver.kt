package com.example.kode.test_task.ui.core

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface BaseObserver<R> {

    fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<R>)
}