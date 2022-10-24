package com.example.kode.data.repository.worker

import com.example.kode.data.datasource.core.DataSourceModel
import com.example.kode.data.datasource.workers.cache.room.WorkerCacheDataSource
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.repository.WorkerRepository
import javax.inject.Inject

class WorkerRepositoryImpl<
        IUM : UseCaseModel, IDM : DataSourceModel<IDM>,
        RDM : DataSourceModel<RDM>, RUM : UseCaseModel,
        >
@Inject constructor(
    private val workerCacheDataSource: WorkerCacheDataSource<IDM, RDM>,
    private val mapperIn: Base.Mapper<IUM, IDM>,
    private val mapper: Base.Mapper<RDM, RUM>,
) : WorkerRepository<IUM, RUM> {

    override suspend fun getWorker(model: IUM): RUM =
        workerCacheDataSource.get(model.let(mapperIn::map)).map(mapper)
}