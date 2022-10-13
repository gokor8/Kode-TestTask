package com.example.kode.test_task.di

import android.content.Context
import android.content.res.Resources
import com.example.kode.test_task.di.annotations.ApplicationContext
import com.example.kode.test_task.di.modules.ui.viewmodels.BViewModelModule
import com.example.kode.test_task.di.subcomponents.MainFragmentSubcomponent
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.WorkerFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @ApplicationContext
            context: Context,
            @BindsInstance
            resources: Resources
        ): AppComponent
    }

    fun createMainFragmentSubcomponent(): MainFragmentSubcomponent.Factory

    fun inject(workerFragment: WorkerFragment)
}