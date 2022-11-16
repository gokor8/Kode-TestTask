package com.example.kode.test_task.di.modules.ui.communications

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MainCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.communications.WorkerCommunication
import dagger.Binds
import dagger.Module
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.NullableCommunication


@Module
interface BCommunicationModule {

    @Binds
    fun bindMainCommunication(communication: MainCommunication): NullableCommunication<MainStatesUI>

    @Binds
    fun bindWorkerCommunication(communication: WorkerCommunication): NullableCommunication<WorkerStatesUI>
}