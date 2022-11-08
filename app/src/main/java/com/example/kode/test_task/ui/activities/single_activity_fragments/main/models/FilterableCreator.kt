package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import com.example.kode.domain.core.sort.SortUseCaseModel
import com.example.kode.domain.core.sort.SortableUseCaseModel

interface FilterableCreator<IM, RM : SortableUseCaseModel<*>> {
    fun createFilterable(toSortList: List<IM>): SortUseCaseModel<RM>
}