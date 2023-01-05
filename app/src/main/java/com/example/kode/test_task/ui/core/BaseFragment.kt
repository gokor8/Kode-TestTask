package com.example.kode.test_task.ui.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.App
import com.example.kode.test_task.ui.core.provides.ProvideActivity
import com.example.kode.test_task.ui.core.provides.ProvideApp
import com.example.kode.test_task.ui.core.view_model.BaseViewModel

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel<*, *>> : Fragment(),
    BaseInterfaceView<VB, VM>, ProvideActivity, ProvideApp {

    val binding: VB by lazy { setBind() }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) = binding.root

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUI()
        setObservers()
        setListeners()
    }
}