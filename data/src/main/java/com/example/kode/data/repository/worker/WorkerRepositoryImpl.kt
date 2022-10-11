package com.example.kode.data.repository.worker

import com.example.kode.data.datasource.core.DataSourceModel
import com.example.kode.data.datasource.workers.cache.room.WorkerCacheDataSource
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.repository.WorkerRepository
import javax.inject.Inject

class WorkerRepositoryImpl<IM : UseCaseModel<IM>, MR : DataSourceModel<MR>, M : UseCaseModel<M>>
@Inject constructor(
    private val workerCacheDataSource: WorkerCacheDataSource<IM, MR>,
    private val mapper: Base.Mapper<MR, M>,
) : WorkerRepository<IM, M> {

    override suspend fun getWorker(model: IM): M = workerCacheDataSource.get(model).map(mapper)
}