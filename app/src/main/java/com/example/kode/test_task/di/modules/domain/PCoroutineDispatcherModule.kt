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

}