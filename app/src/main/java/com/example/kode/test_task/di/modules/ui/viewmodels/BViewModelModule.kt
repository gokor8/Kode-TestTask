package com.example.kode.test_task.di.modules.ui.viewmodels

import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.domain.entity.worker.WorkerInputEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.di.modules.domain.BUseCaseModule
import com.example.kode.test_task.di.modules.ui.communications.BCommunicationModule
import com.example.kode.test_task.di.modules.ui.mappers.BUIMapperModule
import com.example.kode.test_task.ui.activities.SingleActivityViewModel
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainViewModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainViewModelFactory
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.WorkerViewModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import dagger.Binds
import dagger.Module

@Module(includes = [BCommunicationModule::class, BUIMapperModule::class, BUseCaseModule::class])
interface BViewModelModule {

    @Binds
    fun bindMainViewModel(mainViewModel: MainViewModel<SingleActivityStatesUI, MainStatesUI, WorkersStateEntity>)
            : MainViewModel<SingleActivityStatesUI, MainStatesUI, *>

//    @Binds
//    fun bindSingleActivityViewModel(mainViewModel: SingleActivityViewModel<SingleActivityStatesUI>)
//            : SingleActivityViewModel<SingleActivityStatesUI>

    @Binds
    fun bindWorkerViewModel(workerViewModel: WorkerViewModel<WorkerStatesUI, WorkerInputEntity, WorkerFullStateEntity>)
            : WorkerViewModel<WorkerStatesUI, *, *>
}