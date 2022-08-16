package com.example.kode.data.datasource.workers.cloud

import com.example.kode.data.datasource.workers.cloud.service.WorkersService
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import com.example.kode.domain.entity.workers.WorkersStateEntity
import java.lang.Exception
import java.net.UnknownHostException
import javax.inject.Inject

class WorkersCloudDataSourceImpl<R, M : Any> @Inject constructor(
    private val apiService: WorkersService<M>,
    private val workersResponseMapper: Base.Mapper<M, R>
    ) : WorkersCloudDataSource<R> {

    override suspend fun get(): R = try {
        apiService.getWorkers().let(workersResponseMapper::map)
    } catch (e: UnknownHostException) {
        throw NoConnectionException()
    }
}