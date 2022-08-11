package com.example.kode.data.datasource.workers.cloud

import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.domain.core.Base
import javax.inject.Inject

class WorkersCloudDataSourceImpl<R, M : Any> @Inject constructor(
    private val apiService: WorkersService<M>,
    private val workersResponseMapper: Base.Mapper<M, R>
    ) : WorkersCloudDataSource<R> {

    override fun get(): R = apiService.getWorkers().let(workersResponseMapper::map)
}