package com.example.kode.test_task.di.modules.ui.viewmodels

import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.di.modules.domain.BUseCaseModule
import com.example.kode.test_task.di.modules.ui.communications.BCommunicationModule
import com.example.kode.test_task.di.modules.ui.mappers.BUIMapperModule
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainViewModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import dagger.Binds
import dagger.Module

@Module(includes = [BCommunicationModule::class, BUIMapperModule::class, BUseCaseModule::class])
interface BViewModelModule {

    @Binds
    fun bindMainViewModel(mainViewModel: MainViewModel<MainStatesUI, WorkersStateEntity>): MainViewModel<MainStatesUI, *>
}