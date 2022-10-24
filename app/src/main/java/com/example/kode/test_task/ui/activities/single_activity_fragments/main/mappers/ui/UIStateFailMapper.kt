package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import javax.inject.Inject

class UIStateFailMapper @Inject constructor(
    private val searchErrorMapper: Base.Mapper<MainResultStatesUI.Fail.SearchError, Unit>,
    private val usualErrorMapper: Base.Mapper<MainResultStatesUI.Fail.UsualError, Unit>,
    private val fatalErrorMapper: Base.Mapper<MainResultStatesUI.Fail.FatalError, Unit>
): Base.Mapper<MainResultStatesUI.Fail, Unit> {

    override fun map(model: MainResultStatesUI.Fail) = when(model) {
        is MainResultStatesUI.Fail.SearchError -> searchErrorMapper.map(model)
        is MainResultStatesUI.Fail.UsualError -> usualErrorMapper.map(model)
        is MainResultStatesUI.Fail.FatalError -> fatalErrorMapper.map(model)
    }
}