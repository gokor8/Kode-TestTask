package com.example.kode.test_task.di.modules.domain

import com.example.kode.domain.core.Read
import com.example.kode.domain.core.sort.SortUseCaseModel
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.domain.entity.worker.WorkerInputEntity
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkerSortableEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.sort.SortUseCase
import com.example.kode.domain.usecase.worker.GetWorkerUseCase
import com.example.kode.domain.usecase.worker.GetWorkerUseCaseImpl
import com.example.kode.domain.usecase.workers.GetWorkersUseCase
import com.example.kode.domain.usecase.workers.GetWorkersUseCaseImpl
import com.example.kode.test_task.di.modules.data.BRepositoryModule
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [PCoroutineDispatcherModule::class, BRepositoryModule::class, BMapperModule::class])
interface BUseCaseModule {

    @Binds
    fun bindGetWorkersUseCase(useCase: GetWorkersUseCaseImpl<WorkersStateEntity, WorkerInfoEntity>)
            : GetWorkersUseCase<WorkersStateEntity, WorkerInfoEntity>

    @Binds
    fun bindGetWorkerUseCase(useCase: GetWorkerUseCaseImpl<WorkerInputEntity, WorkerFullStateEntity>)
            : GetWorkerUseCase<WorkerInputEntity, WorkerFullStateEntity>

    /*@Binds
    fun bindSortUseCase(sortUseCase: SortUseCase<WorkerSortableEntity, WorkersStateEntity>)
            : Read.AbstractInput.SuspendEquable<SortUseCaseModel<WorkerSortableEntity>, WorkersStateEntity>*/

    /*@Provides
    fun provideUseCase(sortUseCase: SortUseCase<WorkerSortableEntity, WorkersStateEntity>)
            : Read.AbstractInput.SuspendEquable<SortUseCaseModel<WorkerSortableEntity>, WorkersStateEntity> {
        return sortUseCase
    }*/
}
