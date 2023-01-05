package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.domain.usecase.workers.WorkersSearchUseCase
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MixSearchCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.temp_searchable.UISearchState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.search.SearchViewModel
import com.example.kode.test_task.ui.core.search.UISearch
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel<IM : SingleActivityStatesUI, RM : MainStatesUI, EM : UseCaseModel>
@Inject constructor(
    override val communication: MixSearchCommunication<RM>,
    private val mapper: Base.Mapper<EM, RM>,
    private val useCase: GetWorkersUseCase<EM>,
    private val searchSortUseCase: WorkersSearchUseCase<Pair<String, RM>, EM>
    ) : SearchViewModel<MixSearchCommunication<RM>, RM, IM>(), UISearch<IM> {

    fun initialization() {
        if (communication.isEmpty()) getWorkers()
    }

    fun getWorkers() = viewModelScope.launch {
        mapper.map(useCase.get()).let(communication::save)
    }

    override fun search(searchState: IM) {
        viewModelScope.launch {
            val fullWorkers = communication.get()

            if (fullWorkers == null) {
                communication.searchSave(UISearchState.Skip())
                return@launch
            }

            if (searchState is SingleActivityStatesUI.Cancel) {
                communication.notifyIt()
            } else if (searchState is SingleActivityStatesUI.Search) {
                searchSortUseCase.get(
                    Pair(
                        searchState.searchText,
                        fullWorkers
                    )
                ).let(mapper::map).let(communication::save)
            }
        }
    }
}