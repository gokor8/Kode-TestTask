package com.example.kode.test_task.ui.core

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : Activity(),
    BaseInterfaceView<VB, VM> {

    val binding: VB by lazy { setBind() }
    val viewModel: VM by lazy { setViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUI()
        setObservers()
        setListeners()
    }
}