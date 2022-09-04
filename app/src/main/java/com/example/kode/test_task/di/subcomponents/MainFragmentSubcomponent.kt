package com.example.kode.test_task.di.subcomponents

import android.content.Context
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.di.annotations.MainFragmentContext
import com.example.kode.test_task.di.modules.ui.BUIAddons
import com.example.kode.test_task.di.modules.ui.PUIAddons
import com.example.kode.test_task.di.modules.ui.mappers.BUIStateMapperModule
import com.example.kode.test_task.di.modules.ui.recycler_views.UnitedRecyclerViewModule
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragment
import dagger.BindsInstance
import dagger.Subcomponent

@MainFragmentScope
@Subcomponent(modules = [UnitedRecyclerViewModule::class,
    BUIStateMapperModule::class, PUIAddons::class, BUIAddons::class])
interface MainFragmentSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @MainFragmentContext
            context: Context,
            @BindsInstance
            binding: FragmentMainBinding,
        ): MainFragmentSubcomponent
    }

    fun inject(mainFragment: MainFragment)
}