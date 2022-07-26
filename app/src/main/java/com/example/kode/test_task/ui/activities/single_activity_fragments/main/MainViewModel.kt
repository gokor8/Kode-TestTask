package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.core.BaseCommunication
import com.example.kode.test_task.ui.core.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel<M : Any, EM : Base.IgnorantMapper<EM>> @Inject constructor(
    communication: BaseCommunication<M>,
    private val mapper: Base.Mapper<EM, M>,
    private val useCase: GetWorkersUseCase<EM>
) : BaseViewModel<M>(communication) {

    fun getWorkers() = viewModelScope.launch {
        useCase.getWorkers().map(mapper).let(communication::save)
    }
}