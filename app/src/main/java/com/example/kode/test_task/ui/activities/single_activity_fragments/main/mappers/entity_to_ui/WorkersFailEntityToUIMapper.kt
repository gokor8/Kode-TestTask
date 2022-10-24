package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.R
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import javax.inject.Inject

class WorkersFailEntityToUIMapper @Inject constructor() :
    Base.Mapper<WorkersStateEntity.Fail, MainResultStatesUI.Fail> {

    override fun map(model: WorkersStateEntity.Fail): MainResultStatesUI.Fail = when (model.exception) {
        is UseCaseExceptions.NoCacheException -> MainResultStatesUI.Fail.FatalError()
        else -> MainResultStatesUI.Fail.UsualError(R.string.generic_error)
    }
}