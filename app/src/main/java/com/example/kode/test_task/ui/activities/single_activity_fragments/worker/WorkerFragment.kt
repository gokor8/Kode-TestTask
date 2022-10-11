package com.example.kode.test_task.ui.activities.single_activity_fragments.worker

import androidx.fragment.app.viewModels
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainViewModelFactory
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.BaseFragment
import javax.inject.Inject

class WorkerFragment : BaseFragment<ItemMainBinding, WorkerViewModel<WorkerStatesUI, *, *>>() {

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory<MainStatesUI>

    override val viewModel: WorkerViewModel<WorkerStatesUI, *, *> by viewModels { viewModelFactory }

    override fun setBind(): ItemMainBinding = ItemMainBinding.inflate(layoutInflater)

    override fun setUI() {
        viewModel.getWorker()
    }
}