package com.example.kode.test_task.ui.activities

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import javax.inject.Inject

class WorkersStateEntityToListPositions @Inject constructor() : Base.Mapper<WorkersStateEntity, List<String>> {

    override fun map(model: WorkersStateEntity): List<String> = when(model) {
        is WorkersStateEntity.Success -> model.workers.map { it.position }
        is WorkersStateEntity.NoConnection -> model.workers.map { it.position }
            is WorkersStateEntity.Fail -> emptyList()
    }
}