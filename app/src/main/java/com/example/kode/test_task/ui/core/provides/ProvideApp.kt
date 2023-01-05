package com.example.kode.test_task.ui.core.provides

import com.example.kode.test_task.App

interface ProvideApp : RequireActivity {

    fun provideApp() = requireActivity().applicationContext as App
}