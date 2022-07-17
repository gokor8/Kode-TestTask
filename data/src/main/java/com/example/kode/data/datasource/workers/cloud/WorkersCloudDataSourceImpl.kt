package com.example.kode.data.datasource.workers.cloud

import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.domain.core.Base

class WorkersCloudDataSourceImpl<R, M : Base.IgnorantMapper<M>>(
    private val api: WorkersService<M>,
    private val workersResponseMapper: Base.Mapper<M, R>
    ) : WorkersCloudDataSource<R> {

    override fun get(): R = api.getWorkers().map(workersResponseMapper)
}