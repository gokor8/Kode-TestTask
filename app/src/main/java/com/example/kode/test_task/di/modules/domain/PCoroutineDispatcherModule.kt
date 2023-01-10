package com.example.kode.test_task.di.modules.domain

import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.domain.entity.workers.sort.name.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.sort.user_tag.WorkerUserTagSortableEntity
import com.example.kode.domain.usecase.sort.StringStateSortUseCase
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStateSuccessAndListToSortableState
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.MainStatesUIToWorkersStringSortEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui_to_entity.PAIR_WITH_MAIN
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
class PCoroutineDispatcherModule {

    @Provides
    fun provideIODispatcher(): CoroutineContext = Dispatchers.IO

    @Provides
    fun bindMainStatesUIToWorkersStringSortEntity(
        toSortableStateEntity: Base.Mapper<PAIR_WITH_MAIN, WorkersSortableStateEntity>,
        mainStateSuccessToUserTag: Base.Mapper<MainStatesUI.Success, List<WorkerUserTagSortableEntity>>,
        mainStateSuccessToName: Base.Mapper<MainStatesUI.Success, List<WorkerNameSortableEntity>>,
    ): Base.Mapper<Pair<String, MainStatesUI.Success>, StringSortEntity<WorkersSortableStateEntity, WorkerStringSortableEntity>> {
        return MainStatesUIToWorkersStringSortEntity(
            toSortableStateEntity,
            mainStateSuccessToUserTag,
            mainStateSuccessToName
        )
    }

    @Provides
    fun bindMainStateSuccessAndListToSortableState(): Base.Mapper<PAIR_WITH_MAIN, WorkersSortableStateEntity> {
        return MainStateSuccessAndListToSortableState()
    }

    @Provides
    fun bindWorkersStringStateSortUseCase(
        coroutineContext: CoroutineContext,
        failMapper: Base.Mapper<Exception, WorkersStateEntity>,
        toStateMapper: Base.Mapper<WorkersSortableStateEntity, WorkersStateEntity>,
    ): StringStateSortUseCase<WorkersSortableStateEntity, WorkerStringSortableEntity, WorkersStateEntity> {
        return StringStateSortUseCase(
            coroutineContext, failMapper, toStateMapper
        )
    }

}