package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success

import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import javax.inject.Inject

class UICloudStateMapper @Inject constructor(
    adapter: BaseRecyclerViewAdapter<WorkerInfoUIModel, ItemMainBinding, MainViewHolder>
): UISuccessMapper<MainStatesUI.Success.Cloud>(adapter)