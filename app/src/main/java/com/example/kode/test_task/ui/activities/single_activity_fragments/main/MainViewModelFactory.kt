package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import com.example.kode.test_task.ui.core.viewmodels.BaseViewModelFactory
import javax.inject.Inject

class MainViewModelFactory<M : Any> @Inject constructor(
    private val viewModel: MainViewModel
) : BaseViewModelFactory<MainViewModel> {

    override val modelClass = MainViewModel::class.java

    override fun createViewModel() = viewModel
}