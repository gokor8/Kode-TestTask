package com.example.kode.test_task.ui.core.search

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

interface ObserveSearch<M> {
    fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<M>)
}