package com.example.kode.test_task.ui.core

abstract class NullableCommunication<M : Any> : BaseCommunication<M>(), Nullable {

    override fun isEmpty() = liveData.value == null

    override fun isNotEmpty() = liveData.value != null
}