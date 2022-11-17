package com.example.kode.test_task.ui.core

import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.ui.core.view_model.BaseViewModel

interface BaseInterfaceView<VB : ViewBinding, VM : BaseViewModel<*, *>> : BaseView {

    val viewModel: VM

    fun setBind(): VB
}