package com.example.kode.test_task.di.modules.ui.communications

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MainCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.communications.WorkerCommunication
import com.example.kode.test_task.ui.core.BaseCommunication
import dagger.Binds
import dagger.Module
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI


@Module
interface BCommunicationModule {

    @Binds
    fun bindMainCommunication(communication: MainCommunication): BaseCommunication<MainStatesUI>

    @Binds
    fun bindWorkerCommunication(communication: WorkerCommunication): BaseCommunication<WorkerStatesUI>
}