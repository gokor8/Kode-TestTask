package com.example.kode.test_task.di.modules.domain

import com.example.kode.data.repository.worker.mappers.ExceptionToFailWorkerFullMapper
import com.example.kode.data.repository.workers.mappers.ExceptionToFailEntityMapper
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.domain.entity.workers.sort.name.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.sort.user_tag.WorkerUserTagSortableEntity
import com.example.kode.domain.usecase.workers.mappers.ListWorkerInfoToListWorkerNameSortable
import com.example.kode.domain.usecase.workers.mappers.ListWorkerNameSortableToListWorkerInfo
import com.example.kode.domain.usecase.workers.mappers.WorkersSortableStateToWorkersState
import com.example.kode.domain.usecase.workers.mappers.WorkersStateToWorkersNameSortableState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStateSuccessToName
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStateSuccessToUserTag
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import dagger.Binds
import dagger.Module

@Module
interface BMapperModule {

    @Binds
    fun bindExceptionToFailEntityMapper(mapper: ExceptionToFailEntityMapper)
            : Base.Mapper<Exception, WorkersStateEntity>

    @Binds
    fun bindExceptionToFailWorkerFullEntityMapper(mapper: ExceptionToFailWorkerFullMapper)
            : Base.Mapper<Exception, WorkerFullStateEntity>

    @Binds
    fun bindWorkersStateEntitySuccessToNameSortable(mapper: ListWorkerNameSortableToListWorkerInfo)
            : Base.Mapper<List<WorkerStringSortableEntity>, List<WorkerInfoEntity>>

    @Binds
    fun bindWorkersNameSortableStateToWorkersState(mapper: WorkersSortableStateToWorkersState)
            : Base.Mapper<WorkersSortableStateEntity, WorkersStateEntity>

    @Binds
    fun bindWorkersStateToWorkersNameSortableState(mapper: WorkersStateToWorkersNameSortableState)
            : Base.Mapper<WorkersStateEntity.Success, WorkersSortableStateEntity>

    @Binds
    fun bindListWorkerInfoToListWorkerNameSortable(mapper: ListWorkerInfoToListWorkerNameSortable)
            : Base.Mapper<List<WorkerInfoEntity>, List<WorkerNameSortableEntity>>

//    @Binds
//    fun bindMainStatesUIToWorkersStringSortEntity(mapper: MainStatesUIToWorkersStringSortEntity)
//            : Base.Mapper<Pair<String, MainStatesUI>, StringSortEntity<WorkersSortableStateEntity, WorkerStringSortableEntity>>

    @Binds
    fun bindMainStateSuccessToUserTag(mapper: MainStateSuccessToUserTag)
            : Base.Mapper<MainStatesUI.Success, List<WorkerUserTagSortableEntity>>

    @Binds
    fun bindMainStateSuccessToName(mapper: MainStateSuccessToName)
            : Base.Mapper<MainStatesUI.Success, List<WorkerNameSortableEntity>>
}
