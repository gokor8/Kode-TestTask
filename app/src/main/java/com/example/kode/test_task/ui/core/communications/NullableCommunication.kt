package com.example.kode.test_task.ui.core.communications

import com.example.kode.domain.core.Nullable

abstract class NullableCommunication<M : Any> : LiveDataCommunication<M>(), Nullable {

    override fun isEmpty() = savedValue.value == null

    override fun isNotEmpty() = savedValue.value != null
}