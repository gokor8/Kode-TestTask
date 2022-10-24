package com.example.kode.test_task.di.modules.ui.mappers

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.search.UISearchInputStateToMainSearchState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.search.UISearchInputToMainSearchMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UIStateFailMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UIStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UIStateSuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail.UIFatalErrorStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail.UISearchErrorMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail.UIUsualErrorStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UICacheStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UICloudStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISearchStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStateUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.UISearchInputState
import dagger.Binds
import dagger.Module

@Module
interface BUIWorkersStateMapperModule {

    @Binds
    fun bindUIStateMapper(
        uiStateMapper: UIStateMapper,
    ): Base.Mapper<MainResultStatesUI, Unit>

    @Binds
    fun bindUIStateSuccessMapper(uiStateSuccessMapper: UIStateSuccessMapper)
            : Base.Mapper<MainResultStatesUI.Success, Unit>

    @Binds
    fun bindUICacheStateMapper(uiCacheStateMapper: UICacheStateMapper)
            : UISuccessMapper<MainResultStatesUI.Success.Cache>

    @Binds
    fun bindUICloudStateMapper(uiCloudStateMapper: UICloudStateMapper)
            : UISuccessMapper<MainResultStatesUI.Success.Cloud>

    @Binds
    fun bindUISearchStateMapper(uiCloudStateMapper: UISearchStateMapper)
            : UISuccessMapper<MainResultStatesUI.Success.Search>

    @Binds
    fun bindUIStateFailMapper(uiStateFailMapper: UIStateFailMapper)
            : Base.Mapper<MainResultStatesUI.Fail, Unit>

    @Binds
    fun bindUIFatalErrorStateMapper(uIFatalErrorStateMapper: UIFatalErrorStateMapper)
            : Base.Mapper<MainResultStatesUI.Fail.FatalError, Unit>

    @Binds
    fun bindUISearchErrorMapper(uiSearchErrorMapper: UISearchErrorMapper)
            : Base.Mapper<MainResultStatesUI.Fail.SearchError, Unit>

    @Binds
    fun bindUIUsualErrorStateMapper(uIUsualErrorStateMapper: UIUsualErrorStateMapper)
            : Base.Mapper<MainResultStatesUI.Fail.UsualError, Unit>

    @Binds
    fun bindUiSearchInputToStateMapper(uiSearchInputToStateMapper: UISearchInputStateToMainSearchState)
            : Base.Mapper<UISearchInputState, MainSearchStateUI>

    @Binds
    fun bindSearchToMainSearchStateMapper(UISearchInputToMainSearchMapper: UISearchInputToMainSearchMapper)
            : Base.Mapper<UISearchInputState.Search, MainSearchStateUI.SearchUI<*>>
}