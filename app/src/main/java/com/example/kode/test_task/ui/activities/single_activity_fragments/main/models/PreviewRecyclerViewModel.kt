package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import androidx.navigation.NavController
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewModel

data class PreviewRecyclerViewModel(
    val id: String,
    val avatarUrl: String,
    val name: String,
    val lastName: String,
    val userTag: String,
    val position: String,
    val navController: NavController,
) : BaseRecyclerViewModel<Int> {

    override fun getRVEqualsValue() = hashCode()
}