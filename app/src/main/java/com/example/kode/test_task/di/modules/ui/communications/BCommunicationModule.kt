package com.example.kode.test_task.di.modules.ui.communications

import com.example.kode.test_task.ui.activities.SingleActivityCommunication
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MixSearchCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.NewMainCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.communications.WorkerCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.communications.BaseCommunication
import com.example.kode.test_task.ui.core.search.states.UISearchState
import dagger.Binds
import dagger.Module


@Module
interface BCommunicationModule {

    @Binds
    fun bindMainCommunication(communication: NewMainCommunication): MixSearchCommunication<MainStatesUI, MainSearchStates>

    @Binds
    fun bindWorkerCommunication(communication: WorkerCommunication): BaseCommunication<WorkerStatesUI>

    @Binds
    fun bindSingleActivityCommunication(communication: SingleActivityCommunication): BaseCommunication<SingleActivityStatesUI>
}