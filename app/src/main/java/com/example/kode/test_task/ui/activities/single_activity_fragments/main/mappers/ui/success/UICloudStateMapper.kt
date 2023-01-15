package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success

import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import com.example.kode.test_task.ui.core.visibility_handler.VisibilityVGHandler
import java.lang.ref.WeakReference
import javax.inject.Inject

class UICloudStateMapper @Inject constructor(
    @MainFragmentBinding
    binding: WeakReference<FragmentMainBinding>,
    visibilityVGHandler: VisibilityVGHandler,
    adapter: BaseRecyclerViewAdapter<PreviewWorkerInfoUIModel, ItemMainBinding, MainViewHolder>
): UISuccessMapper<MainStatesUI.Success.Cloud>(adapter, binding, visibilityVGHandler)