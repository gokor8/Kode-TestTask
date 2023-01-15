package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success

import androidx.annotation.CallSuper
import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import com.example.kode.test_task.ui.core.visibility_handler.VisibilityVGHandler
import java.lang.ref.WeakReference

abstract class UISuccessMapper<M : MainStatesUI.Success>(
    protected val adapter: BaseRecyclerViewAdapter<PreviewWorkerInfoUIModel, ItemMainBinding, MainViewHolder>,
    protected val binding: WeakReference<FragmentMainBinding>,
    protected val visibilityVGHandler: VisibilityVGHandler
) : Base.Mapper<M, Unit> {

    @CallSuper
    override fun map(model: M) {
        // Надо было сделать холдером, но там много переделывать
        binding.get()?.apply {
            visibilityVGHandler.comboInverse(rvMain, llSearchError)
        }
        adapter.submitList(model.workers)
    }
}