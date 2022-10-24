package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success

import androidx.annotation.CallSuper
import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter

abstract class UISuccessMapper<M : MainResultStatesUI.Success>(
    protected val adapter: BaseRecyclerViewAdapter<PreviewWorkerInfoUIModel, ItemMainBinding, MainViewHolder>
) : Base.Mapper<M, Unit> {

    @CallSuper
    override fun map(model: M) {
        adapter.submitList(model.workers)
    }
}