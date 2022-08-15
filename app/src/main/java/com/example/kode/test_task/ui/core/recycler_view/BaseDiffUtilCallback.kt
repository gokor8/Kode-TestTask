package com.example.kode.test_task.ui.core.recycler_view

import androidx.recyclerview.widget.DiffUtil
import javax.inject.Inject
import kotlin.jvm.internal.Intrinsics

class BaseDiffUtilCallback<M : BaseRecyclerViewModel<*>> @Inject constructor() : DiffUtil.ItemCallback<M>() {

    override fun areItemsTheSame(oldItem: M, newItem: M): Boolean {
        return oldItem.getRVEqualsValue() == newItem.getRVEqualsValue()
    }

    override fun areContentsTheSame(oldItem: M, newItem: M): Boolean {
        return oldItem.equals(newItem)
    }
    // Жалуется на непереопределенный equals у object
}