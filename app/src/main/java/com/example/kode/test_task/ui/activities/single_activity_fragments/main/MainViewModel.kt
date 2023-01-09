package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.core.usecase.UseCaseSuspend
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.MixSearchCommunication
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainCommunicationModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.search.SearchViewModel
import com.example.kode.test_task.ui.core.search.UISearch
import com.example.kode.test_task.ui.core.search.states.UISearchState
import com.example.kode.test_task.ui.core.search.states.factories.DefaultUISearchStateFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel<IM : SingleActivityStatesUI, RM : MainCommunicationModel,
        RSM : MainCommunicationModel.Success, SM : UISearchState, EM : UseCaseModel>
@Inject constructor(
    override val communication: MixSearchCommunication<RM, SM>,
    private val mapper: Base.Mapper<EM, RM>,
    private val useCase: GetWorkersUseCase<EM>,
    private val searchMapper: Base.Mapper<EM, SM>,
    private val searchStateFactory: DefaultUISearchStateFactory<SM>,
    private val searchSortUseCase: UseCaseSuspend.UseCaseWithInput<Pair<String, RSM>, EM>,
) : SearchViewModel<MixSearchCommunication<RM, SM>, RM, SM, IM>(), UISearch<IM> {

    fun initialization() {
        if (communication.isEmpty()) getWorkers()
    }

    fun getWorkers() = viewModelScope.launch {
        mapper.map(useCase.get()).also(communication::save)
    }

    override fun search(searchState: IM) {
        val mainState = communication.get() as? RSM

        if (mainState == null) {
            communication.searchSave(searchStateFactory.createSkip())
            return
        }

        if (searchState is SingleActivityStatesUI.Cancel)
            communication.notifyIt()
        else if (searchState is SingleActivityStatesUI.Search)
            viewModelScope.launch {
                searchSortUseCase.get(
                    Pair(
                        searchState.searchText,
                        mainState
                    )
                ).let(searchMapper::map).also(communication::searchSave)
            }
    }
}