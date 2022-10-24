package com.example.kode.test_task.ui.activities.single_activity_fragments.worker

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kode.domain.core.Base
import com.example.kode.test_task.App
import com.example.kode.test_task.databinding.FragmentWorkerBinding
import com.example.kode.test_task.ui.activities.SingleActivity
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.fragments.BaseFragment
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
        (requireActivity() as SingleActivity).binding.iSearch.cToolbar.isVisible = false
        viewModel.getWorker(
            WorkerFragmentArgs.fromBundle(requireArguments()).userId
        )
    }

    override fun setListeners() = with(binding) {
        ibBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun setObservers() = viewModel.observe(viewLifecycleOwner) {
        uiStateMapper.map(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        provideApp<App>().daggerAppComponent
            .createWorkerFragmentSubcomponent()
            .create(WeakReference(binding))
            .inject(this)
    }
}