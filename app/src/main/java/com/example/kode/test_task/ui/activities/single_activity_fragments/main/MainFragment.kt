package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.App
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.*
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.BaseFragment
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel<MainStatesUI, *>>() {

    @Inject
    lateinit var registrationViewModel: MainViewModel<MainStatesUI, WorkersStateEntity>

    @Inject
    lateinit var recyclerAdapter: BaseRecyclerViewAdapter<WorkerInfoUIModel, ItemMainBinding, MainViewHolder>

    override fun setUI() {
        binding.rvMain.adapter = recyclerAdapter
        binding.rvMain.layoutManager = LinearLayoutManager(context)
        viewModel.getWorkers()
    }

    override fun setListeners() {
        binding.tvTryAgain.setOnClickListener {
            binding.vfMain.showPrevious()
            viewModel.getWorkers()
        }
    }

    override fun setObservers() {
        viewModel.observe(viewLifecycleOwner) {
            when (it) {
                is MainStatesUI.Success.Cloud -> it.map(
                    UISuccessModel(recyclerAdapter)
                )
                is MainStatesUI.Success.Cache -> it.map(
                    UICacheSuccessModel(
                        requireContext(),
                        requireView(),
                        recyclerAdapter
                    )
                )
                is MainStatesUI.Fail.UsualError -> it.map(
                    UIUsualErrorModel(
                        requireContext(),
                        requireView()
                    )
                )
                is MainStatesUI.Fail.FatalError -> binding.vfMain.showNext()
            }
        }
    }

    override fun setBind() = FragmentMainBinding.inflate(layoutInflater)

    override fun setViewModel() = registrationViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as App)
            .daggerAppComponent
            .createMainFreagmentSubcomponent()
            .create(context, binding)
            .inject(this)
    }

    override fun onDetach() {
        super.onDetach()
    }

}