package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import javax.inject.Inject

class UIStateSuccessMapper @Inject constructor(
    private val uiStateSearchMapper: UISuccessMapper<MainResultStatesUI.Success.Search>,
    private val uiStateCloudMapper: UISuccessMapper<MainResultStatesUI.Success.Cloud>,
    private val uiStateCacheMapper: UISuccessMapper<MainResultStatesUI.Success.Cache>
): Base.Mapper<MainResultStatesUI.Success, Unit> {

    override fun map(model: MainResultStatesUI.Success) = when(model) {
        is MainResultStatesUI.Success.Cloud -> uiStateCloudMapper.map(model)
        is MainResultStatesUI.Success.Cache -> uiStateCacheMapper.map(model)
        is MainResultStatesUI.Success.Search -> uiStateSearchMapper.map(model)
    }
}