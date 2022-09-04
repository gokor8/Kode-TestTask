package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class UIStateFailMapper @Inject constructor(
    private val usualErrorMapper: Base.Mapper<MainStatesUI.Fail.UsualError, Unit>,
    private val fatalErrorMapper: Base.Mapper<MainStatesUI.Fail.FatalError, Unit>
): Base.Mapper<MainStatesUI.Fail, Unit> {
    override fun map(model: MainStatesUI.Fail) = when(model) {
        is MainStatesUI.Fail.UsualError -> usualErrorMapper.map(model)
        is MainStatesUI.Fail.FatalError -> fatalErrorMapper.map(model)
    }
}