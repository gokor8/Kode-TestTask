package com.example.kode.test_task.ui.core

abstract class NullableCommunication<M : Any> : LiveDataCommunication<M>(), Nullable {

    override fun isEmpty() = liveData.value == null

    override fun isNotEmpty() = liveData.value != null
}