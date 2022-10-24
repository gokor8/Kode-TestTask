package com.example.kode.test_task.ui.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModel

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel<*, *>> : AppCompatActivity(),
    BaseInterfaceView<VB, VM> {

    val binding: VB by lazy { setBind() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUI()
        setObservers()
        setListeners()
    }
}