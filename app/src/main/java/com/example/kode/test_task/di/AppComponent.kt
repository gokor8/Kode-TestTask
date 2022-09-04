package com.example.kode.test_task.di

import android.content.Context
import android.content.res.Resources
import com.example.kode.test_task.di.annotations.ApplicationContext
import com.example.kode.test_task.di.modules.ui.recycler_views.BRecyclerViewModule
import com.example.kode.test_task.di.modules.ui.recycler_views.UnitedRecyclerViewModule
import com.example.kode.test_task.di.modules.ui.viewmodels.BViewModelModule
import com.example.kode.test_task.di.subcomponents.MainFragmentSubcomponent
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @ApplicationContext
            @BindsInstance context: Context,
            @BindsInstance resources: Resources
        ): AppComponent
    }

    fun createMainFreagmentSubcomponent(): MainFragmentSubcomponent.Factory
}