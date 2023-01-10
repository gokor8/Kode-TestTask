package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.domain.entity.workers.sort.name.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.sort.user_tag.WorkerUserTagSortableEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

typealias PAIR_WITH_MAIN = Pair<@JvmSuppressWildcards
List<@JvmSuppressWildcards WorkerStringSortableEntity>, @JvmSuppressWildcards MainStatesUI.Success>

class MainStatesUIToWorkersStringSortEntity @Inject constructor(
    private val toSortableStateEntity: Base.Mapper<PAIR_WITH_MAIN, WorkersSortableStateEntity>,
    private val mainStateSuccessToUserTag: Base.Mapper<MainStatesUI.Success, List<WorkerUserTagSortableEntity>>,
    private val mainStateSuccessToName: Base.Mapper<MainStatesUI.Success, List<WorkerNameSortableEntity>>,
) : Base.Mapper<Pair<@JvmSuppressWildcards String, MainStatesUI.Success>,
        StringSortEntity<WorkersSortableStateEntity, WorkerStringSortableEntity>> {

    override fun map(model: Pair<String, MainStatesUI.Success>)
            : StringSortEntity<WorkersSortableStateEntity, WorkerStringSortableEntity> {
        val currentState = model.second

        val workersSortableList =
            if (model.first.length == 2 && model.first.all { it.isUpperCase() })
                mainStateSuccessToUserTag.map(currentState)
            else
                mainStateSuccessToName.map(currentState)


        return StringSortEntity(
            model.first,
            toSortableStateEntity.map(Pair(workersSortableList, currentState))
        )
    }
}