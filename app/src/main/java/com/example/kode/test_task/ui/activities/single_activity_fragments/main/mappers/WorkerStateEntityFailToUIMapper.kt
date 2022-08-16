package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.R
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class WorkerStateEntityFailToUIMapper @Inject constructor() : Base.Mapper<WorkersStateEntity.Fail, MainStatesUI.Error> {
    override fun map(model: WorkersStateEntity.Fail): MainStatesUI.Error = when(model.exception) {
        is Exceptions.GenericException -> MainStatesUI.Error(R.string.generic_error)
    }
}