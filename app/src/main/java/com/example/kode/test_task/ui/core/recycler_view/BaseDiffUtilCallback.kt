package com.example.kode.test_task.ui.core.recycler_view

import androidx.recyclerview.widget.DiffUtil
import kotlin.jvm.internal.Intrinsics

class BaseDiffUtilCallback<M : BaseRecyclerViewModel<*>> : DiffUtil.ItemCallback<M>() {

    override fun areItemsTheSame(oldItem: M, newItem: M): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: M, newItem: M): Boolean =
        Intrinsics.areEqual(oldItem.getRVEqualsValue(), newItem.getRVEqualsValue())

    // Жалуется на непереопределенный equals у object
}