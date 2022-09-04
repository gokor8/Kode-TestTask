package com.example.kode.test_task.di.subcomponents

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.di.annotations.MainFragmentBinding
import com.example.kode.test_task.di.annotations.MainFragmentContext
import com.example.kode.test_task.di.modules.ui.recycler_views.UnitedRecyclerViewModule
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [UnitedRecyclerViewModule::class])
interface MainFragmentSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @MainFragmentContext
            context: Context,
            @BindsInstance
            @MainFragmentBinding
            binding: ViewBinding
        ): MainFragmentSubcomponent
    }

    fun inject(mainFragment: MainFragment)
}