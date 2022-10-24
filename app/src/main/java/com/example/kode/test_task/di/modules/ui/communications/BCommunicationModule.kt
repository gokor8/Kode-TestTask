package com.example.kode.test_task.di.modules.ui.communications

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MainCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.communications.WorkerCommunication
import dagger.Binds
import dagger.Module
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.communications.BaseCommunication
import com.example.kode.test_task.ui.core.communications.NullableCommunication


@Module
interface BCommunicationModule {

    @Binds
    fun bindMainCommunication(communication: MainCommunication): NullableCommunication<MainResultStatesUI>

    @Binds
    fun bindWorkerCommunication(communication: WorkerCommunication): BaseCommunication<WorkerStatesUI>

    @Binds
    fun bindMainResultStatesUICommunication(communication: MainCommunication): BaseCommunication<MainResultStatesUI>
}