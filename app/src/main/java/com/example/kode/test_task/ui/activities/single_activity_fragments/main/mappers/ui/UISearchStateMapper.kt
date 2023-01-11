package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success.UISuccessMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import javax.inject.Inject

class UISearchStateMapper @Inject constructor(
    private val uiStateSearchSuccessMapper: UISuccessMapper<MainSearchStates.SearchSuccess>,
    private val uiStateSearchNotFound: Base.Mapper<MainSearchStates.SearchNotFound, Unit>,
) : Base.Mapper<MainSearchStates, Unit> {

    override fun map(model: MainSearchStates) {
        when (model) {
            is MainSearchStates.SearchSuccess -> uiStateSearchSuccessMapper.map(model)
            is MainSearchStates.SearchNotFound -> uiStateSearchNotFound.map(model)
            else -> {}
        }
    }
}