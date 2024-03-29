package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import android.content.Context
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.SingleActivity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.BaseFragment
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import java.lang.ref.WeakReference
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel<MainStatesUI, *>>() {

    @Inject
    lateinit var recyclerAdapter: BaseRecyclerViewAdapter<PreviewWorkerInfoUIModel, ItemMainBinding, MainViewHolder>

    @Inject
    lateinit var uiStateMapper: Base.Mapper<MainStatesUI, Unit>

    @Inject
    lateinit var viewModelFactory: MainViewModelFactory<MainStatesUI>

    override val viewModel: MainViewModel<MainStatesUI, *> by viewModels { viewModelFactory }

    override fun setUI(): Unit = with(binding) {
        (requireActivity() as SingleActivity).binding.iSearch.cToolbar.isVisible = true

        rvMain.adapter = recyclerAdapter
        rvMain.layoutManager = LinearLayoutManager(context)

        viewModel.getWorkers()
    }

    override fun setListeners() {
        binding.iError.tvTryAgain.setOnClickListener {
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