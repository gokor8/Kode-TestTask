package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.communications

import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.communications.BaseCommunication
import com.example.kode.test_task.ui.core.communications.LiveDataCommunication
import com.example.kode.test_task.ui.core.communications.NullableCommunication
import javax.inject.Inject

class WorkerCommunication @Inject constructor() : LiveDataCommunication<WorkerStatesUI>()