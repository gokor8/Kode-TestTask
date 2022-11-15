package com.example.kode.test_task.ui.activities

import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.core.communications.LiveDataCommunication
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModel
import kotlinx.coroutines.launch

class SingleActivityViewModel(
    communication: LiveDataCommunication<List<String>>,
    private val workersStateEntityToList: Base.Mapper<WorkersStateEntity, List<String>>,
    private val getWorkersUseCase: GetWorkersUseCase<WorkersStateEntity, WorkerInfoEntity>,
) : BaseViewModel<LiveDataCommunication<List<String>>, List<String>>(communication) {

    fun getPositions() {
        viewModelScope.launch {
            val workers = getWorkersUseCase.get(null).let(workersStateEntityToList::map)

            if (workers.isNotEmpty()) {
                workers.let(communication::save)
            }
        }
    }
}

// Сделать какие-то модели
// getWorkersUseCase будет принимать модель или стрингу просто, по ней сортировать и выдвавать