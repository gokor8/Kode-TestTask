package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.sort.WorkersCacheSortableStateEntity
import com.example.kode.domain.entity.workers.sort.WorkersCloudSortableStateEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class MainStateSuccessAndListToSortableState @Inject constructor() :
    Base.Mapper<PAIR_WITH_MAIN, WorkersSortableStateEntity> {

    override fun map(model: PAIR_WITH_MAIN): WorkersSortableStateEntity = when (model.second) {
        is MainStatesUI.Success.Cloud -> WorkersCloudSortableStateEntity(model.first)
        is MainStatesUI.Success.Cache -> WorkersCacheSortableStateEntity(model.first)
        else -> WorkersCloudSortableStateEntity(model.first)
    }
}