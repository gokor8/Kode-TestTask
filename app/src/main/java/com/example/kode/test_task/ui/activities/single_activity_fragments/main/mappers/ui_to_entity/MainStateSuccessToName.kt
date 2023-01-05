package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.sort.name.WorkerNameSortableEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class MainStateSuccessToName @Inject constructor() :
    Base.Mapper<MainStatesUI.Success, List<@JvmSuppressWildcards WorkerNameSortableEntity>> {

    override fun map(model: MainStatesUI.Success): List<WorkerNameSortableEntity> {
        return model.workers.map {
            with(it) {
                WorkerNameSortableEntity(id, avatarUrl, name, lastName, userTag, position)
            }
        }
    }
}