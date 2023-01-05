package com.example.kode.test_task.ui.activities

import com.example.kode.test_task.ui.core.view_model.BaseViewModelFactory
import javax.inject.Inject

class SingleActivityViewModelFactory <M : Any> @Inject constructor(
    private val viewModel: SingleActivityViewModel<M>
) : BaseViewModelFactory<SingleActivityViewModel<*>> {

    override val modelClass: Class<SingleActivityViewModel<*>> = SingleActivityViewModel::class.java

    override fun createViewModel() = viewModel

}