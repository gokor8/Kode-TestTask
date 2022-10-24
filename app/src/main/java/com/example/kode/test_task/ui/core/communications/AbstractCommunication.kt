package com.example.kode.test_task.ui.core.communications

abstract class AbstractCommunication<VM, M> : BaseCommunication<M> {

    protected abstract val savedValue: VM

}