package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import com.example.kode.test_task.ui.core.search.states.UISearchState

sealed interface MainSearchStates : UISearchState {
    class SearchSuccess(workers: List<PreviewWorkerInfoUIModel>) : MainStatesUI.Success(workers), MainSearchStates,
        UISearchState.Success
    class SearchNotFound : MainStatesUI.Fail(), MainSearchStates, UISearchState.Fail
    class SearchSkip : MainSearchStates, UISearchState.Skip
}