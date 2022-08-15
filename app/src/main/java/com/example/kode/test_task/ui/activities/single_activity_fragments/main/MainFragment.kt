package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.App
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainRV
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.BaseFragment
import com.example.kode.test_task.ui.core.recycler_view.BaseDiffUtilCallback
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import com.example.kode.test_task.ui.core.recycler_view.BaseViewHolderFactory
import com.google.android.material.snackbar.Snackbar
import java.util.*
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel<MainStatesUI, *>>() {

    @Inject
    lateinit var registrationViewModel: MainViewModel<MainStatesUI, WorkersStateEntity>

    @Inject
    lateinit var holderFactory: BaseViewHolderFactory<ItemMainBinding, MainViewHolder>

    val diffUtils: BaseDiffUtilCallback<WorkerInfoUIModel> = BaseDiffUtilCallback()

    var recyclerAdapter: ListAdapter<WorkerInfoUIModel, MainRV.WorkerViewHolder>? = null//BaseRecyclerViewAdapter<WorkerInfoUIModel, ItemMainBinding, MainViewHolder>? = null

    override fun setObservers() {
        viewModel.observe(viewLifecycleOwner) {
            when (it) {
                is MainStatesUI.Success -> {
                    recyclerAdapter?.submitList(it.workers)
                    //Log.i("MainFragmentInfo", it.workers.toString())
                }
                is MainStatesUI.Fail.Error -> {
                    Snackbar.make(
                        this.requireView(),
                        resources.getString(it.errorId),
                        Snackbar.LENGTH_LONG
                    ).show()
                    //Log.i("MainFragmentInfo", resources.getString(it.errorId))
                }
                is MainStatesUI.Fail.NoConnection -> {}
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        (requireActivity().application as App).daggerAppComponent.inject(this)
    }

    override fun setBind() = FragmentMainBinding.inflate(layoutInflater)

    override fun setViewModel() = registrationViewModel

    override fun setUI() {

        recyclerAdapter = MainRV()/* BaseRecyclerViewAdapter(
            holderFactory,
            diffUtils
        )*/

        binding.rvMain.adapter = recyclerAdapter
        binding.rvMain.layoutManager = LinearLayoutManager(context)
        viewModel.getWorkers()
    }

    override fun onDestroy() {
        recyclerAdapter = null

        super.onDestroy()
    }

}