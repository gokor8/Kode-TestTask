package com.example.kode.test_task.ui.core.search.states.factories

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.search.states.UISearchSkip
import com.example.kode.test_task.ui.core.search.states.UISearchState
import javax.inject.Inject

class DefaultUISearchStateFactoryImpl @Inject constructor() : DefaultUISearchStateFactory<UISearchState> {
    override fun createSkip(): UISearchState = UISearchSkip()
}
