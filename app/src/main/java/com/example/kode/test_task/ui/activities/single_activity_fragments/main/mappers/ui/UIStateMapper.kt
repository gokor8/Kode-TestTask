package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class UIStateMapper @Inject constructor(
    private val successMapper: Base.Mapper<MainStatesUI.Success, Unit>,
    private val failMapper: Base.Mapper<MainStatesUI.Fail, Unit>
) : Base.Mapper<MainStatesUI, Unit> {

    override fun map(model: MainStatesUI) = when(model) {
        is MainStatesUI.Success -> successMapper.map(model)
        is MainStatesUI.Fail -> failMapper.map(model)
    }
}