package com.example.kode.test_task.ui.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel<*>> : Fragment(),
    BaseInterfaceView<VB, VM> {

    lateinit var binding: VB
    val viewModel: VM by lazy { setViewModel() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = setBind().also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUI()
        setObservers()
        setListeners()
    }
}