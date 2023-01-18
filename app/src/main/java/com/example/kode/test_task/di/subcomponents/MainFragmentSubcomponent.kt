package com.example.kode.test_task.di.subcomponents

import android.content.Context
import android.view.View
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentContext
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentView
import com.example.kode.test_task.di.modules.ui.mappers.BUIWorkersSearchStateMapperModule
import com.example.kode.test_task.di.modules.ui.mappers.BUIWorkersStateMapperModule
import com.example.kode.test_task.di.modules.ui.recycler_views.BRecyclerViewModule
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragment
import dagger.BindsInstance
import dagger.Subcomponent
import java.lang.ref.WeakReference

@MainFragmentScope
@Subcomponent(modules = [BRecyclerViewModule::class, BUIWorkersSearchStateMapperModule::class,
    BUIWorkersStateMapperModule::class])
interface MainFragmentSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @MainFragmentContext
            context: WeakReference<Context>,
            @BindsInstance
            @MainFragmentBinding
            binding: WeakReference<FragmentMainBinding>,
            @BindsInstance
            @MainFragmentView
            view: WeakReference<View>,
        ): MainFragmentSubcomponent
    }

    fun inject(mainFragment: MainFragment)
}