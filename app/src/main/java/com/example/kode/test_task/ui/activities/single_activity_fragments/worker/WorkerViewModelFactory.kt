package com.example.kode.test_task.ui.activities.single_activity_fragments.worker

import com.example.kode.test_task.ui.core.view_model.BaseViewModelFactory
import javax.inject.Inject

class WorkerViewModelFactory<M : Any> @Inject constructor(
    private val viewModel: WorkerViewModel<M, *, *>
) : BaseViewModelFactory<WorkerViewModel<*, *, *>> {

    override val modelClass: Class<WorkerViewModel<*, *, *>> = WorkerViewModel::class.java

    override fun createViewModel(): WorkerViewModel<*, *, *> = viewModel

}