package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.search

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStateUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.UISearchInputState
import javax.inject.Inject

class UISearchInputStateToMainSearchState @Inject constructor(
    private val searchMapper: Base.Mapper<UISearchInputState.Search, MainSearchStateUI.SearchUI<*>>
) : Base.Mapper<UISearchInputState, MainSearchStateUI> {

    override fun map(model: UISearchInputState): MainSearchStateUI = when(model) {
        is UISearchInputState.Search -> searchMapper.map(model)
        else -> MainSearchStateUI.Cancel()
    }
}