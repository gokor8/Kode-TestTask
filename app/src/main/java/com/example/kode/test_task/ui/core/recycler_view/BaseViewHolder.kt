package com.example.kode.test_task.ui.core.recycler_view

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<M : Any>(item: View) : RecyclerView.ViewHolder(item) {

    abstract fun onBind(model: M)
}