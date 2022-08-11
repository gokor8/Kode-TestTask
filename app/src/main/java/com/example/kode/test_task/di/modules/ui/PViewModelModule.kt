package com.example.kode.test_task.di.modules.ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.di.modules.domain.PUseCaseModule
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainViewModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.BaseCommunication
import dagger.Module
import dagger.Provides

@Module(
    includes = [BCommunicationModule::class, BUIMapperModule::class, PUseCaseModule::class,
            PUIMapperModule::class
    ]
)
class PViewModelModule {

    @Provides
    fun provideMainViewModel(
        communication: BaseCommunication<MainStatesUI>,
        toUIMapper: Base.Mapper<WorkersStateEntity, MainStatesUI>,
        useCase: GetWorkersUseCase<WorkersStateEntity>
    ) = MainViewModel(
        communication,
        toUIMapper,
        useCase
    )
}
