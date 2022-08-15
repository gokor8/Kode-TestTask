package com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.core.recycler_view.BaseViewHolderFactory
import javax.inject.Inject

class MainViewHolderFactory @Inject constructor() : BaseViewHolderFactory<ItemMainBinding, MainViewHolder>() {
    override fun bind(
        layoutInflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ItemMainBinding = ItemMainBinding.inflate(layoutInflater, parent, false)

    override fun build(viewBinding: ItemMainBinding): MainViewHolder = MainViewHolder(viewBinding)
}