package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.core.BaseCommunication
import com.example.kode.test_task.ui.core.BaseViewModel
import com.example.kode.test_task.ui.core.NullableCommunication
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel<M : Any, EM : UseCaseModel<EM>> @Inject constructor(
    communication: NullableCommunication<M>,
    private val mapper: Base.Mapper<EM, M>,
    private val useCase: GetWorkersUseCase<EM>
) : BaseViewModel<NullableCommunication<M>, M>(communication) {

    fun getWorkers() = viewModelScope.launch {
        if(communication.isEmpty())
            useCase.get().map(mapper).let(communication::save)
    }
}