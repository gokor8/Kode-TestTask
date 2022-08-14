package com.example.kode.test_task.ui.core.recycler_view

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter

class BaseRecyclerViewAdapter<M : BaseRecyclerViewModel<*>, VH : BaseViewHolder<M>>(
    private val viewHolderFactory: BaseViewHolderFactory<VH>,
    diffUtilCallback: BaseDiffUtilCallback<M>
) : ListAdapter<M, VH>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH = viewHolderFactory.create()

    override fun onBindViewHolder(holder: VH, position: Int) {
        val itemPosition = getItem(position)

        holder.onBind(itemPosition)
    }
}