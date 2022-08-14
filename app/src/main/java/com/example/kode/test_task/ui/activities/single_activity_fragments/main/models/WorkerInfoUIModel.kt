package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewModel

data class WorkerInfoUIModel(
    val avatarUrl: String,
    val name: String,
    val lastName: String,
    val userTag: String,
    val position: String
) : BaseRecyclerViewModel<Int> {

    override fun getRVEqualsValue(): Int = hashCode()
}