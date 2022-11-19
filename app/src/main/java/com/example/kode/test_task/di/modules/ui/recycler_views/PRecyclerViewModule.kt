package com.example.kode.test_task.di.modules.ui.recycler_views

import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.di.subcomponents.MainFragmentScope
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewRecyclerViewModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseDiffUtilCallback
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import com.example.kode.test_task.ui.core.recycler_view.BaseViewHolderFactory
import dagger.Module
import dagger.Provides

@Module
class PRecyclerViewModule {

    @MainFragmentScope
    @Provides
    fun provideBaseRecyclerViewAdapter(
        viewHolder: BaseViewHolderFactory<ItemMainBinding, MainViewHolder>,
        diffUtils: BaseDiffUtilCallback<PreviewRecyclerViewModel>
    ): BaseRecyclerViewAdapter<PreviewRecyclerViewModel, ItemMainBinding, MainViewHolder> =
        BaseRecyclerViewAdapter(
            viewHolder,
            diffUtils
        )
}