package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.communications

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.BaseCommunication
import com.example.kode.test_task.ui.core.LiveDataCommunication
import com.example.kode.test_task.ui.core.NullableBaseCommunication
import javax.inject.Inject

class WorkerCommunication @Inject constructor() : LiveDataCommunication<WorkerStatesUI>()