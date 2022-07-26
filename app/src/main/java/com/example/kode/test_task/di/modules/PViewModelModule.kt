package com.example.kode.test_task.di.modules

import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainViewModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import dagger.Module
import dagger.Provides

@Module
class PViewModelModule {

    @Provides
    fun provideMainViewModel() = MainViewModel<MainStatesUI, WorkersStateEntity>(

    )
}
