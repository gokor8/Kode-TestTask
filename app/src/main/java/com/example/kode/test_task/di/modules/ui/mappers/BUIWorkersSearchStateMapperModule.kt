package com.example.kode.test_task.di.modules.ui.mappers

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UISearchStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.search.UISearchNotFoundStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.search.UISearchSuccessStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import dagger.Binds

import dagger.Module

@Module
interface BUIWorkersSearchStateMapperModule {

    @Binds
    fun bindUISearchStateMapper(uiSearchStateMapper: UISearchStateMapper)
            : Base.Mapper<MainSearchStates, Unit>

    @Binds
    fun bindUIStateSearchSuccessMapper(uiSearchSuccessStateMapper: UISearchSuccessStateMapper)
            : UISuccessMapper<MainSearchStates.SearchSuccess>

    @Binds
    fun bindUISearchNotFoundStateMapper(uiSearchNotFoundStateMapper: UISearchNotFoundStateMapper)
            : Base.Mapper<MainSearchStates.SearchNotFound, Unit>
}