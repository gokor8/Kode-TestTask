package com.example.kode.test_task.ui.core.recycler_view

import androidx.viewbinding.ViewBinding

abstract class BaseViewHolderFactory<VH : BaseViewHolder<*>> {

    fun create(): VH {
        val viewBinding = bind()

        return build(viewBinding)
    }

    protected abstract fun bind(): ViewBinding

    protected abstract fun build(viewBinding: ViewBinding): VH
}