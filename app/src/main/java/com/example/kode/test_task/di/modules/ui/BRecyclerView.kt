package com.example.kode.test_task.di.modules.ui

import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolderFactory
import com.example.kode.test_task.ui.core.recycler_view.BaseViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseViewHolderFactory
import dagger.Binds
import dagger.Module

@Module
interface BRecyclerView {

    @Binds
    fun bindHolderFactory(factory: MainViewHolderFactory): BaseViewHolderFactory<ItemMainBinding, MainViewHolder>

}
