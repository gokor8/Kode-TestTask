package com.example.kode.test_task.ui.activities

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainViewModel
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModelFactory
import javax.inject.Inject

class SingleActivityViewModelFactory @Inject constructor(
    private val viewModel: SingleActivityViewModel
) : BaseViewModelFactory<SingleActivityViewModel> {

    override val modelClass = SingleActivityViewModel::class.java

    override fun createViewModel() = viewModel
}