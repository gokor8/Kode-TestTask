package com.example.kode.test_task.di.modules.ui.state_factories

import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainStatesUIFactory
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.core.search.states.UISearchState
import com.example.kode.test_task.ui.core.search.states.factories.DefaultUISearchStateFactory
import com.example.kode.test_task.ui.core.search.states.factories.DefaultUISearchStateFactoryImpl
import dagger.Binds
import dagger.Module

@Module
interface StateFactoriesModule {

    @Binds
    fun bindDefaultUISearchStateFactoryImpl(defaultUISearchStateFactoryImpl: DefaultUISearchStateFactoryImpl)
            : DefaultUISearchStateFactory<UISearchState>

    @Binds
    fun bindMainStatesUIFactory(mainStatesUIFactory: MainStatesUIFactory): DefaultUISearchStateFactory<MainSearchStates>
}