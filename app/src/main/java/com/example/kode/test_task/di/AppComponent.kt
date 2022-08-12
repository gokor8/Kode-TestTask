package com.example.kode.test_task.di

import android.content.Context
import android.content.res.Resources
import com.example.kode.test_task.di.modules.ui.BViewModelModule
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [BViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance resources: Resources
        ): AppComponent
    }

    fun inject(mainFragment: MainFragment)

}