package com.example.kode.test_task.di.modules.data.cache.realm

import com.example.kode.data.datasource.workers.cache.realm.mappers.LRealmModelToWorkerInfoMapper
import com.example.kode.data.datasource.workers.cache.realm.mappers.LWorkerInfoDataModelToRealmMapper
import com.example.kode.data.datasource.workers.cache.realm.mappers.RealmModelToWorkerInfoMapper
import com.example.kode.data.datasource.workers.cache.realm.mappers.WorkerInfoDataModelToRealmMapper
import com.example.kode.data.datasource.workers.cache.realm.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import dagger.Binds
import dagger.Module

@Module
interface BRealmCacheDataSourceMapperModule {

    @Binds
    fun bindLWorkerInfoDataModelToRealmMapper(mapper: LWorkerInfoDataModelToRealmMapper)
            : Base.Mapper<WorkersInfoStateDataModel, MutableList<RealmWorkerModel>>

    @Binds
    fun bindLRealmModelToWorkerInfoMapper(mapper: LRealmModelToWorkerInfoMapper)
            : Base.Mapper<MutableList<RealmWorkerModel>, WorkersInfoStateDataModel>

    @Binds
    fun bindRealmModelToWorkerInfoMapper(mapper: RealmModelToWorkerInfoMapper)
            : Base.Mapper<RealmWorkerModel, WorkerInfoDataModel>

    @Binds
    fun bindWorkerInfoDataModelToRealmMapper(mapper: WorkerInfoDataModelToRealmMapper)
            : Base.Mapper<WorkerInfoDataModel, RealmWorkerModel>
}