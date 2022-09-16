package com.example.kode.test_task.ui.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.App
import javax.inject.Inject

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel<*>> : Fragment(),
    BaseInterfaceView<VB, VM> {

    val binding: VB by lazy { setBind() }
    val viewModel: VM by lazy { setViewModel() }

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

    fun getApp(): App = (requireActivity().applicationContext as App)
}