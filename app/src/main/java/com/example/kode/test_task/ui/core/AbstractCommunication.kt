package com.example.kode.test_task.ui.core

// Относледоваться и сделать BaseValueCommunication в конструктор BaseValue
abstract class AbstractCommunication<M : Any, CM> : BaseCommunication<M> {

    protected abstract val communicationModel: CM
}