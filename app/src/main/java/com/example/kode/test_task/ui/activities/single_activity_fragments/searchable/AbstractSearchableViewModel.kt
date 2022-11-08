/*package com.example.kode.test_task.ui.activities.single_activity_fragments.searchable

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.kode.domain.core.Base
import com.example.kode.domain.usecase.sort.SortUseCase
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.communications.SearchableCommunicationImpl
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.UISearchInputState
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.SearchResultStatesUI
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModel
import kotlinx.coroutines.launch

abstract class AbstractSearchableViewModel<UIM : UISearchInputState, UOM : SearchResultStatesUI, SM, RM>(
    communication: SearchableCommunicationImpl<UOM>,
) : BaseViewModel<SearchableCommunicationImpl<UOM>, UOM>(communication), SearchableViewModel<UIM, UOM> {

    protected abstract val sortUseCase: SortUseCase<SM, RM>
    protected abstract val toDomainMapper: UISearchStateToSortUseCaseState<UIM, UOM, SM>
    protected abstract val toUIMapper: Base.Mapper<RM, UOM>

    override fun observeSearch(lifecycleOwner: LifecycleOwner, observer: Observer<UOM>) {
        communication.observeSearch(lifecycleOwner, observer)
    }

    override fun search(searchState: UIM) {
        viewModelScope.launch {
            (communication.get() as? SearchResultStatesUI.Success<SM>)?.let {
                sortUseCase.get(toDomainMapper.map(searchState, it.modelList))
                    .let(toUIMapper::map)
                    .let(communication::save)
            }
        }
    }
}*/
// toDomainMapper.map(searchState) map to Current SortableUseCaseModel with нужный дженерик, по которому будет искать