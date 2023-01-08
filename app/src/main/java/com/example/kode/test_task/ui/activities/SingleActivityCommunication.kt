package com.example.kode.test_task.ui.activities

import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.core.communications.LiveDataCommunication
import javax.inject.Inject

class SingleActivityCommunication @Inject constructor() : LiveDataCommunication<SingleActivityStatesUI>()