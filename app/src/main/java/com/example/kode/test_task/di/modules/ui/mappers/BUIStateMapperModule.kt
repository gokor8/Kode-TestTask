package com.example.kode.test_task.di.modules.ui.mappers

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UIStateFailMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UIStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.UIStateSuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail.UIFatalErrorStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail.UIUsualErrorStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UICacheStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UICloudStateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import dagger.Binds
import dagger.Module

@Module
interface BUIStateMapperModule {

    @Binds
    fun bindUIStateMapper(
        uiStateMapper: UIStateMapper,
    ): Base.Mapper<MainStatesUI, Unit>

    @Binds
    fun bindUIStateSuccessMapper(uiStateSuccessMapper: UIStateSuccessMapper)
            : Base.Mapper<MainStatesUI.Success, Unit>

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
}