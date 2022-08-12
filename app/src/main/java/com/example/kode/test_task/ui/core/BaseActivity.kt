package com.example.kode.test_task.ui.core

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel<*>> : AppCompatActivity(),
    BaseInterfaceView<VB, VM> {

    val binding: VB by lazy { setBind() }
    val viewModel: VM by lazy { setViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUI()
        setObservers()
        setListeners()
    }
}