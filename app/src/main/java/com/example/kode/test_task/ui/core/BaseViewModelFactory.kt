package com.example.kode.test_task.ui.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

interface BaseViewModelFactory<VM : BaseViewModel<*>> : ViewModelProvider.Factory {

    val modelClass: Class<VM>

    fun createViewModel(): VM

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(modelClass)) {
            createViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}