package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success

import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewRecyclerViewModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import javax.inject.Inject

class UICloudStateMapper @Inject constructor(
    adapter: BaseRecyclerViewAdapter<PreviewRecyclerViewModel, ItemMainBinding, MainViewHolder>,
    mapper: Base.Mapper<MainResultStatesUI.Success, List<PreviewRecyclerViewModel>>
): UISuccessMapper<MainResultStatesUI.Success.Cloud>(adapter, mapper)