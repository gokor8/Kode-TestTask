package com.example.kode.test_task.ui.activities.single_activity_fragments.worker

import android.content.Context
import androidx.fragment.app.viewModels
import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.FragmentWorkerBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.BaseFragment
import java.lang.ref.WeakReference
import javax.inject.Inject

class WorkerFragment :
    BaseFragment<FragmentWorkerBinding, WorkerViewModel<WorkerStatesUI, *, *>>() {

    @Inject
    lateinit var uiStateMapper: Base.Mapper<WorkerStatesUI, Unit>

    @Inject
    lateinit var viewModelFactory: WorkerViewModelFactory<WorkerStatesUI>

    override val viewModel: WorkerViewModel<WorkerStatesUI, *, *> by viewModels { viewModelFactory }

    override fun setBind(): FragmentWorkerBinding = FragmentWorkerBinding.inflate(layoutInflater)

    override fun setUI() {
        viewModel.getWorker(
            WorkerFragmentArgs.fromBundle(
                requireArguments()
            ).userId
        )
    }

    override fun setObservers() = viewModel.observe(viewLifecycleOwner) {
        uiStateMapper.map(it)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        getApp().daggerAppComponent
            .createWorkerFragmentSubcomponent()
            .create(WeakReference(binding))
            .inject(this)
    }
}