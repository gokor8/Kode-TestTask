package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import android.content.Context
import android.view.View
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter

class UICacheSuccessModel(
    val context: Context,
    val view: View,
    adapter: BaseRecyclerViewAdapter<WorkerInfoUIModel, *, *>
) : UISuccessModel(adapter)