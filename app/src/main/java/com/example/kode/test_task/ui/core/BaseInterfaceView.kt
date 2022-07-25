package com.example.kode.test_task.ui.core

import androidx.viewbinding.ViewBinding

interface BaseInterfaceView<VB : ViewBinding, VM : BaseViewModel<*>> : BaseView {

    fun setBind(): VB
    fun setViewModel() : VM
}