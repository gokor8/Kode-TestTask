package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.R
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class WorkersFailEntityToUIMapper @Inject constructor() :
    Base.Mapper<WorkersStateEntity.Fail, MainStatesUI.Fail> {

    override fun map(model: WorkersStateEntity.Fail): MainStatesUI.Fail = when (model.exception) {
        is Exceptions.NoCacheException -> MainStatesUI.Fail.FatalError()
        is Exceptions.GenericException -> MainStatesUI.Fail.UsualError(R.string.generic_error)
    }
}