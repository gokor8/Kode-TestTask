package com.example.kode.test_task.di.modules.ui

import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.databinding.FragmentMainBinding
import dagger.Binds
import dagger.Module

@Module
interface BUIAddons {

    @Binds
    fun bindFragmentMainBinding(fragmentBinding: FragmentMainBinding): ViewBinding
}