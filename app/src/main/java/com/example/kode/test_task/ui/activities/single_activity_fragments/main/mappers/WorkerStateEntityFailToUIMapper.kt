package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.R
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI

class WorkerStateEntityFailToUIMapper : Base.Mapper<WorkersStateEntity.Fail, MainStatesUI.Fail> {
    override fun map(model: WorkersStateEntity.Fail): MainStatesUI.Fail = when(model.exception) {
        is Exceptions.GenericException -> MainStatesUI.Fail.Error(R.string.generic_error)
        is Exceptions.NoConnection -> MainStatesUI.Fail.NoConnection()
    }
}