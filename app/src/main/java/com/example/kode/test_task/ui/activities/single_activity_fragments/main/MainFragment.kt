package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.App
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.BaseFragment
import com.example.kode.test_task.ui.core.recycler_view.BaseDiffUtilCallback
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import com.example.kode.test_task.ui.core.recycler_view.BaseViewHolderFactory
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel<MainStatesUI, *>>() {

    @Inject
    lateinit var registrationViewModel: MainViewModel<MainStatesUI, WorkersStateEntity>

    @Inject
    lateinit var holderFactory: BaseViewHolderFactory<ItemMainBinding, MainViewHolder>

    private val diffUtils: BaseDiffUtilCallback<WorkerInfoUIModel> = BaseDiffUtilCallback()

    private var recyclerAdapter: BaseRecyclerViewAdapter<WorkerInfoUIModel, ItemMainBinding, MainViewHolder>? =
        null

    override fun setUI() {

        recyclerAdapter = BaseRecyclerViewAdapter(
            holderFactory,
            diffUtils
        )

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
                is MainStatesUI.Success -> {
                    recyclerAdapter?.let(it::setWorkers)

                    if (it is MainStatesUI.Success.Cache)
                        Snackbar.make(
                            this.requireView(),
                            resources.getString(R.string.no_connection),
                            Snackbar.LENGTH_LONG
                        ).show()
                }
                is MainStatesUI.Fail.UsualError -> {
                    Snackbar.make(
                        this.requireView(),
                        resources.getString(it.errorId),
                        Snackbar.LENGTH_LONG
                    ).show()
                }
                is MainStatesUI.Fail.FatalError -> {
                    binding.vfMain.showNext()
                }
            }
        }
    }

    override fun setBind() = FragmentMainBinding.inflate(layoutInflater)

    override fun setViewModel() = registrationViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as App).daggerAppComponent.inject(this)
    }

    override fun onDestroy() {
        recyclerAdapter = null
        super.onDestroy()
    }

}