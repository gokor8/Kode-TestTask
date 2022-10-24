package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerSortableEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.sort.SortUseCase
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStateUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.SearchableViewModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.communications.SearchableCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.UISearchInputState
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    communication: SearchableCommunication<MainResultStatesUI, MainResultStatesUI>,
    private val useCase: GetWorkersUseCase<WorkersStateEntity>,
    private val sortUseCase: SortUseCase<WorkerSortableEntity, WorkersStateEntity>,
    private val toUIMapper: Base.Mapper<WorkersStateEntity, MainResultStatesUI>,
    private val toMainSearchStateUI: Base.Mapper<UISearchInputState, MainSearchStateUI>,
) : BaseViewModel<SearchableCommunication<MainResultStatesUI, MainResultStatesUI>, MainResultStatesUI>(
    communication),
    SearchableViewModel<UISearchInputState, MainResultStatesUI> {

    fun getWorkers() = viewModelScope.launch {
        useCase.get().let(toUIMapper::map).let(communication::save)
    }

    override fun observeSearch(
        lifecycleOwner: LifecycleOwner,
        observer: Observer<MainResultStatesUI>,
    ) = communication.observeSearch(lifecycleOwner, observer)

    override fun search(searchState: UISearchInputState) {
        viewModelScope.launch {
            val searchState = toMainSearchStateUI.map(searchState)
            val baseCommunicationValue = communication.get()

            if (searchState is MainSearchStateUI.Cancel) {
                communication.save(communication.get())
            } else if (baseCommunicationValue is MainResultStatesUI.Success) {
                val sortableModel = (searchState as MainSearchStateUI.SearchUI<*>)
                    .createFilterable(baseCommunicationValue.workers)

                sortUseCase.get(sortableModel)
                    .let(toUIMapper::map)
                    .let(communication::saveSearch)
            } else {
                communication.saveSearch(MainResultStatesUI.Initial())
            }
        }
    }
}