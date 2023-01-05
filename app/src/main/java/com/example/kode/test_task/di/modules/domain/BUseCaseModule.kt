package com.example.kode.test_task.di.modules.domain

import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.domain.entity.worker.WorkerInputEntity
import com.example.kode.domain.entity.workers.sort.name.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.entity.workers.sort.WorkerStringSortableEntity
import com.example.kode.domain.entity.workers.sort.WorkersSortableStateEntity
import com.example.kode.domain.usecase.sort.AbstractStateSortableUseCase
import com.example.kode.domain.usecase.sort.StringStateSortUseCase
import com.example.kode.domain.usecase.sort.StringStateSortableUseCase
import com.example.kode.domain.usecase.worker.GetWorkerUseCase
import com.example.kode.domain.usecase.worker.GetWorkerUseCaseImpl
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.domain.usecase.workers.GetWorkersUseCaseImpl
import com.example.kode.test_task.di.modules.data.BRepositoryModule
import dagger.Binds
import dagger.Module

@Module(includes = [PCoroutineDispatcherModule::class, BRepositoryModule::class, BMapperModule::class])
interface BUseCaseModule {

    @Binds
    fun bindGetWorkersUseCase(
        useCase: GetWorkersUseCaseImpl<WorkersSortableStateEntity, WorkersStateEntity.WithConnection, WorkersStateEntity>,
    ): GetWorkersUseCase<WorkersStateEntity>

    @Binds
    fun bindGetWorkerUseCase(useCase: GetWorkerUseCaseImpl<WorkerInputEntity, WorkerFullStateEntity>)
            : GetWorkerUseCase<WorkerInputEntity, WorkerFullStateEntity>

//    @Binds
//    fun bindWorkersStringStateSortUseCase(useCase: StringStateSortUseCase<WorkersSortableStateEntity, WorkerStringSortableEntity, WorkersStateEntity>)
//            : StringStateSortUseCase<WorkersSortableStateEntity, WorkerStringSortableEntity, WorkersStateEntity>

    @Binds fun bindStringStateSortableUseCase(sortableUseCase: StringStateSortableUseCase<
            WorkersSortableStateEntity, WorkerStringSortableEntity, WorkersStateEntity>)
            : AbstractStateSortableUseCase<WorkersSortableStateEntity, WorkersStateEntity>
}
