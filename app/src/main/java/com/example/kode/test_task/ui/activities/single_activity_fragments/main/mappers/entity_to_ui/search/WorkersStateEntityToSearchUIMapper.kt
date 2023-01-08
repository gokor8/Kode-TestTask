package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.search

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import javax.inject.Inject

class WorkersStateEntityToSearchUIMapper @Inject constructor(
    private val mapper: Base.Mapper<WorkerInfoEntity, PreviewWorkerInfoUIModel>,
) : Base.Mapper<WorkersStateEntity, MainSearchStates> {

    override fun map(model: WorkersStateEntity): MainSearchStates = when (model) {
        is WorkersStateEntity.Success -> MainSearchStates.SearchSuccess(model.workers.map {
            mapper.map(it)
        })
        is WorkersStateEntity.Fail -> MainSearchStates.SearchNotFound()
    }
}