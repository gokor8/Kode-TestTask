package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.SortUseCase
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MainCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.temp_searchable.UISearchState
import com.example.kode.test_task.ui.core.view_model.BaseViewModel
import com.example.kode.test_task.ui.core.NullableBaseCommunication
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel<M : Any, EM : UseCaseModel> @Inject constructor(
    communication: MainCommunication<M>,
    private val mapper: Base.Mapper<EM, M>,
    private val useCase: GetWorkersUseCase<EM>,
) : BaseViewModel<MainCommunication<M>, M>(communication) {

    fun getWorkers() = viewModelScope.launch {
        if(communication.isEmpty())
            mapper.map(useCase.get()).let(communication::save)
    }

    /*fun search(searchState: SingleActivityStatesUI) {
        if(communication.get() == null) {
            communication.searchSave(UISearchState.Skip())
        }

        if(searchState is SingleActivityStatesUI.Cancel)
            communication.notifyIt()
        else
            communication.save(sortUseCase.sort())
    }*/
}