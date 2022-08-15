package com.example.kode.test_task.ui.core.recycler_view

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<M : Any, VB : ViewBinding>(protected val viewBinding: VB) :
    RecyclerView.ViewHolder(viewBinding.root) {

    abstract fun onBind(model: M)
}
