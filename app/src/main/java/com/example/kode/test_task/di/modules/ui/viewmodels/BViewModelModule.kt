package com.example.kode.test_task.di.modules.ui.viewmodels

import com.example.kode.test_task.di.modules.domain.BUseCaseModule
import com.example.kode.test_task.di.modules.ui.communications.BCommunicationModule
import com.example.kode.test_task.di.modules.ui.mappers.BUIMapperModule
import dagger.Module

@Module(includes = [BCommunicationModule::class, BUIMapperModule::class, BUseCaseModule::class])
interface BViewModelModule {

    /*@Binds
    fun bindMainViewModel(mainViewModel: MainViewModel<MainStatesUI, WorkersStateEntity>): MainViewModel<*, *>*/
}