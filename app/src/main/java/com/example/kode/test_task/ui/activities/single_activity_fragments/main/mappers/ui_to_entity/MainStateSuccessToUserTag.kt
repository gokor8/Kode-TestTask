package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.sort.user_tag.WorkerUserTagSortableEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class MainStateSuccessToUserTag @Inject constructor() :
    Base.Mapper<MainStatesUI.Success, List<@JvmSuppressWildcards WorkerUserTagSortableEntity>> {

    override fun map(model: MainStatesUI.Success): List<WorkerUserTagSortableEntity> {
        return model.workers.map {
            with(it) {
                WorkerUserTagSortableEntity(id, avatarUrl, name, lastName, userTag, position)
            }
        }
    }
}