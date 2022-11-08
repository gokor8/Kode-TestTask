package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import javax.inject.Inject

class UIStateMapper @Inject constructor(
    private val successMapper: Base.Mapper<MainResultStatesUI.Success, Unit>,
    private val failMapper: Base.Mapper<MainResultStatesUI.Fail, Unit>
) : Base.Mapper<MainResultStatesUI, Unit> {

    override fun map(model: MainResultStatesUI) = when(model) {
        is MainResultStatesUI.Success -> successMapper.map(model)
        is MainResultStatesUI.Fail -> failMapper.map(model)
        else -> {}
    }
}