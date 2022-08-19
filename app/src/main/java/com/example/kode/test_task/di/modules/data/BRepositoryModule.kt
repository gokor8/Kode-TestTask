package com.example.kode.test_task.di.modules.data

import com.example.kode.data.repository.workers.WorkersRepositoryImpl
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.repository.WorkersRepository
import com.example.kode.test_task.di.modules.data.cache.BCacheDataSourceModule
import com.example.kode.test_task.di.modules.data.cloud.BCloudDataSourceModule
import dagger.Binds
import dagger.Module

@Module(includes = [BCloudDataSourceModule::class, BMapperModule::class, BCacheDataSourceModule::class])
interface BRepositoryModule {

    // TODO Понять почему не генерит тип с *
    // Скорее всего из-за того что он заполняет его датасурсами, и он знает какой тип получается.
    // А то что я дать пытаюсь, он не может найти, т.к он знает как собрать объект в типами
    @Binds
    fun bindWorkersRepository(repository: WorkersRepositoryImpl<WorkersStateEntity, WorkersInfoStateDataModel>)
            : WorkersRepository<WorkersStateEntity>
}
