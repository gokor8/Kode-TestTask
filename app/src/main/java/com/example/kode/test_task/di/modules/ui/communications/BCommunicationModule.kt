package com.example.kode.test_task.di.modules.ui.communications

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MainCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.NewMainCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.communications.WorkerCommunication
import dagger.Binds
import dagger.Module
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.BaseCommunication
import com.example.kode.test_task.ui.core.NullableBaseCommunication


@Module
interface BCommunicationModule {

    @Binds
    fun bindMainCommunication(communication: NewMainCommunication): MainCommunication<MainStatesUI>

    @Binds
    fun bindWorkerCommunication(communication: WorkerCommunication): BaseCommunication<WorkerStatesUI>

}