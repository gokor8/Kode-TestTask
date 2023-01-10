package com.example.kode.test_task.di.modules.ui.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UIStateFailMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UIStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UIStateSuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail.UIFatalErrorStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail.UIUsualErrorStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UICacheStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UICloudStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISearchSuccessStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStateSuccessAndListToSortableState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStatesUIToWorkersStringSortEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.PAIR_WITH_MAIN
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui.WorkerFailEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui.WorkerFullInfoStateTUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui.WorkerSuccessEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import dagger.Binds
import dagger.Module

@Module
interface BUIWorkersStateMapperModule {

    @Binds
    fun bindUIStateMapper(
        uiStateMapper: UIStateMapper,
    ): Base.Mapper<MainStatesUI, Unit>

    @Binds
    fun bindUIStateSuccessMapper(uiStateSuccessMapper: UIStateSuccessMapper)
            : Base.Mapper<MainStatesUI.Success, Unit>

    @Binds
    fun bindUIStateSearchSuccessMapper(uiSearchSuccessStateMapper: UISearchSuccessStateMapper)
            : UISuccessMapper<MainSearchStates.SearchSuccess>

    @Binds
    fun bindUICacheStateMapper(uiCacheStateMapper: UICacheStateMapper)
            : UISuccessMapper<MainStatesUI.Success.Cache>

    @Binds
    fun bindUICloudStateMapper(uiCloudStateMapper: UICloudStateMapper)
            : UISuccessMapper<MainStatesUI.Success.Cloud>

    @Binds
    fun bindUIStateFailMapper(uiStateFailMapper: UIStateFailMapper)
            : Base.Mapper<MainStatesUI.Fail, Unit>

    @Binds
    fun bindUIFatalErrorStateMapper(uIFatalErrorStateMapper: UIFatalErrorStateMapper)
            : Base.Mapper<MainStatesUI.Fail.FatalError, Unit>

    @Binds
    fun bindUIUsualErrorStateMapper(uIUsualErrorStateMapper: UIUsualErrorStateMapper)
            : Base.Mapper<MainStatesUI.Fail.UsualError, Unit>

//    @Binds
//    fun bindMainStateSuccessAndListToSortableState(mapper: MainStateSuccessAndListToSortableState)
//            : Base.Mapper<PAIR_WITH_MAIN, WorkersSortableStateEntity>
}