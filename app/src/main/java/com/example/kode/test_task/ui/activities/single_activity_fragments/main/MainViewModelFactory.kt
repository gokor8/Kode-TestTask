package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.search.states.UISearchState
import com.example.kode.test_task.ui.core.view_model.BaseViewModelFactory
import javax.inject.Inject
import javax.inject.Named

class MainViewModelFactory<IM : SingleActivityStatesUI, RM : MainStatesUI, SM : MainSearchStates> @Inject constructor(
    private val viewModel: MainViewModel<IM, RM, SM, *>
) : BaseViewModelFactory<MainViewModel<*, *, *, *>> {

    override val modelClass: Class<MainViewModel<*, *, *, *>> = MainViewModel::class.java

    override fun createViewModel() = viewModel
}