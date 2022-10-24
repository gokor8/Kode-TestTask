package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.search

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStateUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.UISearchInputState
import javax.inject.Inject

class UISearchInputToMainSearchMapper @Inject constructor() :
    Base.Mapper<UISearchInputState.Search, MainSearchStateUI.SearchUI<*>> {

    override fun map(model: UISearchInputState.Search) = with(model) {
        if (text.length == 2 || (text.all { it.isUpperCase() } && text.length < 4))
            MainSearchStateUI.NickName(text)
        else
            MainSearchStateUI.FullName(text)
    }
}