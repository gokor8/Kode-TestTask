package com.example.kode.test_task.ui.core.fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.ui.core.BaseInterfaceView
import com.example.kode.test_task.ui.core.BaseObserver
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModel

abstract class BaseFragment<VB : ViewBinding, VM : Any> : Fragment(),
    BaseInterfaceView<VB, VM>, ProvideAppCompatActivity, ProvideApp {

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

    override fun<A : Application> provideApp() = (requireActivity().applicationContext as A)

    override fun<A : AppCompatActivity> provideActivity() = (requireActivity() as A)
}