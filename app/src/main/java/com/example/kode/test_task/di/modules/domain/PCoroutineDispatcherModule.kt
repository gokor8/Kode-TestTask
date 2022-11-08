package com.example.kode.test_task.di.modules.domain

import com.example.kode.domain.core.Read
import com.example.kode.domain.core.sort.SortUseCaseModel
import com.example.kode.domain.entity.workers.WorkerSortableEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.sort.SortUseCase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
class PCoroutineDispatcherModule {

  @Provides
  fun provideIODispatcher(): CoroutineContext = Dispatchers.IO

  @Provides
  fun provideUseCase(sortUseCase: SortUseCase<WorkerSortableEntity, WorkersStateEntity>)
          : Read.AbstractInput.SuspendEquable<SortUseCaseModel<WorkerSortableEntity>, WorkersStateEntity> {
    return sortUseCase
  }
}