package com.example.kode.test_task.di.modules.domain

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.domain.entity.workers.sort.name.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.sort.user_tag.WorkerUserTagSortableEntity
import com.example.kode.domain.usecase.sort.StringStateSortUseCase
import com.example.kode.domain.usecase.workers.mappers.ListWorkerInfoToListWorkerNameSortable
import com.example.kode.domain.usecase.workers.mappers.WorkersStateToWorkersNameSortableState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStateSuccessAndListToSortableState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStateSuccessToName
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStateSuccessToUserTag
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStatesUIToWorkersStringSortEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.PAIR_WITH_MAIN
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import dagger.Binds
import dagger.Module

@Module
interface BMapperSortModule {

    @Binds
    fun bindMainStateSuccessAndListToSortableState(mapper: MainStateSuccessAndListToSortableState)
            : Base.Mapper<PAIR_WITH_MAIN, WorkersSortableStateEntity>

    @Binds
    fun bindMainStateSuccessToUserTag(mapper: MainStateSuccessToUserTag)
            : Base.Mapper<MainStatesUI.Success, List<WorkerUserTagSortableEntity>>

    @Binds
    fun bindMainStateSuccessToName(mapper: MainStateSuccessToName)
            : Base.Mapper<MainStatesUI.Success, List<WorkerNameSortableEntity>>

    @Binds
    fun bindWorkersStateToWorkersNameSortableState(mapper: WorkersStateToWorkersNameSortableState)
            : Base.Mapper<WorkersStateEntity.Success, WorkersSortableStateEntity>

    @Binds
    fun bindListWorkerInfoToListWorkerNameSortable(mapper: ListWorkerInfoToListWorkerNameSortable)
            : Base.Mapper<List<WorkerInfoEntity>, List<WorkerNameSortableEntity>>

    @Binds
    fun bindMainStatesUIToWorkersStringSortEntity(mapper: MainStatesUIToWorkersStringSortEntity)
            : Base.Mapper<Pair<String, MainStatesUI.Success>, StringSortEntity<WorkersSortableStateEntity, WorkerStringSortableEntity>>
}