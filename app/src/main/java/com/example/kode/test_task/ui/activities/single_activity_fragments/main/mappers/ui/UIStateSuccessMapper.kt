package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class UIStateSuccessMapper @Inject constructor(
    private val uiStateCloudMapper: UISuccessMapper<MainStatesUI.Success.Cloud>,
    private val uiStateCacheMapper: UISuccessMapper<MainStatesUI.Success.Cache>
): Base.Mapper<MainStatesUI.Success, Unit> {

    override fun map(model: MainStatesUI.Success) = when(model) {
        is MainStatesUI.Success.Cloud -> uiStateCloudMapper.map(model)
        is MainStatesUI.Success.Cache -> uiStateCacheMapper.map(model)
        else -> {}
    }
}