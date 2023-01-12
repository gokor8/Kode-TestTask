package com.example.kode.test_task.ui.core.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

class BaseRecyclerViewAdapter<M : BaseRecyclerViewModel<*>, VB : ViewBinding, VH : BaseViewHolder<M, VB>> constructor(
    private val viewHolderFactory: BaseViewHolderFactory<VB, VH>,
    diffUtilCallback: DiffUtil.ItemCallback<M>,
) : ListAdapter<M, VH>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return viewHolderFactory.create(
            LayoutInflater.from(parent.context), parent, viewType
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(currentList[position])
    }
}