package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.success

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class WorkersSuccessEntityToUIMapper @Inject constructor(
    private val withConnectionMapper: Base.Mapper<WorkersStateEntity.WithConnection, MainStatesUI.Success.Cloud>,
    private val noConnectionMapper: Base.Mapper<WorkersStateEntity.NoConnection, MainStatesUI.Success.Cache>,
) : Base.Mapper<WorkersStateEntity.Success, MainStatesUI.Success> {
    override fun map(model: WorkersStateEntity.Success): MainStatesUI.Success = when (model) {
        is WorkersStateEntity.WithConnection -> withConnectionMapper.map(model)
        is WorkersStateEntity.NoConnection -> noConnectionMapper.map(model)
    }
}