package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import com.example.kode.test_task.ui.core.view_model.BaseViewModelFactory
import javax.inject.Inject
import javax.inject.Named

class MainViewModelFactory<M : Any> @Inject constructor(
    private val viewModel: MainViewModel<M, *>
) : BaseViewModelFactory<MainViewModel<*, *>> {

    override val modelClass = MainViewModel::class.java

    override fun createViewModel() = viewModel
}