package com.example.kode.test_task.ui.core

import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModel

interface BaseInterfaceView<VB : ViewBinding, VM : Any> : BaseView {

    val viewModel: VM

    fun setBind(): VB
}