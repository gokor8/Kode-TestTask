package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.BaseFragment
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import java.lang.ref.WeakReference
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel<MainStatesUI, *>>() {

    // Сделать адекватное создание вью моделей через vm провайдер
    @Inject
    lateinit var registrationViewModel: MainViewModel<MainStatesUI, WorkersStateEntity>

    @Inject
    lateinit var recyclerAdapter: BaseRecyclerViewAdapter<WorkerInfoUIModel, ItemMainBinding, MainViewHolder>

    @Inject
    lateinit var uiStateMapper: Base.Mapper<MainStatesUI, Unit>

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
            uiStateMapper.map(it)
        }
    }

    override fun setBind() = FragmentMainBinding.inflate(layoutInflater)

    override fun setViewModel() = registrationViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        getApp().daggerAppComponent
            .createMainFragmentSubcomponent()
            .create(
                WeakReference(context),
                WeakReference(binding),
                WeakReference(binding.root)
            )
            .inject(this)
    }
}