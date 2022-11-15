package com.example.kode.test_task.ui.activities.single_activity_fragments

import com.example.kode.test_task.ui.core.communications.LiveDataCommunication
import javax.inject.Inject

class SingleActivityCommunication @Inject constructor() : LiveDataCommunication<List<@JvmSuppressWildcards String>>()