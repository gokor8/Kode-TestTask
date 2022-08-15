package com.example.kode.test_task.ui.core.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.databinding.ItemMainBinding

abstract class BaseViewHolderFactory<VB : ViewBinding, VH : BaseViewHolder<*, VB>> {

    fun create(layoutInflater: LayoutInflater, parent: ViewGroup, viewType: Int): VH {
        val viewBinding = bind(layoutInflater, parent, viewType)

        return build(viewBinding)
    }

    protected abstract fun bind(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): VB

    protected abstract fun build(viewBinding: VB): VH
}