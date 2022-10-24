package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import javax.inject.Inject

class WorkersStateEntityToUIMapper @Inject constructor(
    private val successMapper: Base.Mapper<WorkersStateEntity.Success, MainResultStatesUI.Success.Cloud>,
    private val noConnectionMapper: Base.Mapper<WorkersStateEntity.NoConnection, MainResultStatesUI.Success.Cache>,
    private val failMapper: Base.Mapper<WorkersStateEntity.Fail, MainResultStatesUI.Fail>
) : Base.Mapper<WorkersStateEntity, MainResultStatesUI> {
    override fun map(model: WorkersStateEntity): MainResultStatesUI = when (model) {
        is WorkersStateEntity.Success -> successMapper.map(model)
        is WorkersStateEntity.NoConnection -> noConnectionMapper.map(model)
        is WorkersStateEntity.Fail -> failMapper.map(model)
    }
}