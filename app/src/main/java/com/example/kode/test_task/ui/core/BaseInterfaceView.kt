package com.example.kode.test_task.ui.core

import androidx.viewbinding.ViewBinding

interface BaseInterfaceView<VB : ViewBinding, VM : BaseViewModel<*>> : BaseView {

    val viewModel: VM

    fun setBind(): VB
}