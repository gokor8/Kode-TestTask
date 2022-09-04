package com.example.kode.test_task.di.modules.ui

import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.di.annotations.MainFragmentBinding
import dagger.Module
import dagger.Provides

@Module
class PUIAddons {

    @MainFragmentBinding
    @Provides
    fun provideRootBinding(binding: ViewBinding): View = binding.root
}