package com.example.kode.test_task.ui.activities.single_activity_fragments.worker

import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.usecase.worker.GetWorkerUseCase
import com.example.kode.test_task.ui.core.BaseCommunication
import com.example.kode.test_task.ui.core.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class WorkerViewModel<M : Any, IM : UseCaseModel<IM>, EM : UseCaseModel<EM>> @Inject constructor(
    communication: BaseCommunication<M>,
    private val workerUseCase: GetWorkerUseCase<IM, EM>,
    private val domainToUIMapper: Base.Mapper<EM, M>,
    private val UIToDomainMapper: Base.Mapper<String, IM>,
) : BaseViewModel<M>(communication) {

    fun getWorker(userId: String) = viewModelScope.launch {
        workerUseCase.get(
            UIToDomainMapper.map(userId)
        ).map(domainToUIMapper).let(communication::save)
    }
}