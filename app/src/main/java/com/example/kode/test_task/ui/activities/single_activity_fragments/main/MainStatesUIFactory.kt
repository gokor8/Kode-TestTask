package com.example.kode.test_task.ui.activities.single_activity_fragments.main

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.search.states.factories.DefaultUISearchStateFactory
import javax.inject.Inject

class MainStatesUIFactory @Inject constructor() : DefaultUISearchStateFactory<MainSearchStates> {

    override fun createSkip() = MainSearchStates.SearchSkip()
}