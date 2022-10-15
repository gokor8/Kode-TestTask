package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import javax.inject.Inject

class UIStateMapper@Inject constructor(
    private val workerSuccessMapper: Base.Mapper<WorkerStatesUI.Success, Unit>,
    private val workerFailMapper: Base.Mapper<WorkerStatesUI.FatalError, Unit>
) : Base.Mapper<WorkerStatesUI, Unit> {

    override fun map(model: WorkerStatesUI) = when(model) {
        is WorkerStatesUI.Success -> workerSuccessMapper.map(model)
        is WorkerStatesUI.FatalError -> workerFailMapper.map(model)
    }
}