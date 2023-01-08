package com.example.kode.test_task.ui.core.communications

// Относледоваться и сделать BaseValueCommunication в конструктор BaseValue
abstract class AbstractCommunication<M : Any, CM> : BaseCommunication<M> {

    abstract val communicationModel: CM
}