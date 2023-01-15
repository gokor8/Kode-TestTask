package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.search

import androidx.core.view.isVisible
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import java.lang.ref.WeakReference
import javax.inject.Inject

class UISearchSuccessStateMapper @Inject constructor(
    @MainFragmentBinding
    private val binding: WeakReference<FragmentMainBinding>,
    adapter: BaseRecyclerViewAdapter<PreviewWorkerInfoUIModel, ItemMainBinding, MainViewHolder>
): UISuccessMapper<MainSearchStates.SearchSuccess>(adapter) {

    override fun map(model: MainSearchStates.SearchSuccess) {
        binding.get()?.llSearchError?.isVisible = false
        binding.get()?.rvMain?.isVisible = true
        super.map(model)
    }
}