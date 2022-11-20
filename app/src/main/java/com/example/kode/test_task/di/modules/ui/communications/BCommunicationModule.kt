package com.example.kode.test_task.di.modules.ui.communications

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MainBaseCommunicationImpl
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.communications.WorkerBaseCommunication
import dagger.Binds
import dagger.Module
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.NullableBaseCommunication


@Module
interface BCommunicationModule {

    @Binds
    fun bindMainCommunication(communication: MainBaseCommunicationImpl): NullableBaseCommunication<MainStatesUI>

    @Binds
    fun bindWorkerCommunication(communication: WorkerBaseCommunication): NullableBaseCommunication<WorkerStatesUI>
}