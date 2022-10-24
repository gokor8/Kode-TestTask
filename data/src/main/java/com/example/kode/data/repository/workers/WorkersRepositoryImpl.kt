package com.example.kode.data.repository.workers

import com.example.kode.data.datasource.core.DataSourceModel
import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSource
import com.example.kode.domain.core.Base
import com.example.kode.domain.core.usecase.UseCaseModel
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import com.example.kode.domain.repository.WorkersRepository
import javax.inject.Inject

class WorkersRepositoryImpl<R : UseCaseModel, M : DataSourceModel<M>> @Inject constructor(
    private val cloudDataSource: WorkersCloudDataSource<M>,
    private val cacheDataSource: WorkersCacheDataSource<M>,
    private val mapper: Base.Mapper<M, R>
) : WorkersRepository<R> {
    override suspend fun getWorkers(): R {
        var data: M
        try {
            data = cloudDataSource.get()
            cacheDataSource.save(data)
        } catch (e: NoConnectionException) {
            data = cacheDataSource.get()
        }

        return data.map(mapper)
    }
}