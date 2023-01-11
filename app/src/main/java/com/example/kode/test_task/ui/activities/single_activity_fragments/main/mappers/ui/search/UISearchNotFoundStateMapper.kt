package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.search

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import javax.inject.Inject

class UISearchNotFoundStateMapper @Inject constructor() :
    Base.Mapper<MainSearchStates.SearchNotFound, Unit> {
    override fun map(model: MainSearchStates.SearchNotFound) {

    }
}