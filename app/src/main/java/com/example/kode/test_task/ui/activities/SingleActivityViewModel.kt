package com.example.kode.test_task.ui.activities

import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.activities.single_activity_fragments.SingleActivityCommunication
import com.example.kode.test_task.ui.core.communications.LiveDataCommunication
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class SingleActivityViewModel @Inject constructor(
    communication: SingleActivityCommunication,
    private val getWorkersUseCase: GetWorkersUseCase<WorkersStateEntity, String>,
) : BaseViewModel<LiveDataCommunication<List<String>>, List<String>>(communication) {

    fun getPositions() {
        viewModelScope.launch {
            val workers = getWorkersUseCase.get(null)

            if (workers is WorkersStateEntity.Success) {
                workers.workers.map { it.position }.let(communication::save)
            }
        }
    }
}

// Сделать какие-то модели
// getWorkersUseCase будет принимать модель или стрингу просто, по ней сортировать и выдвавать