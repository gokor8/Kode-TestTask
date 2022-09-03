package com.example.kode.data.datasource.workers.cache.room

import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.exceptions.NoCacheException
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.domain.core.Base
import java.io.IOException
import javax.inject.Inject

class RoomWorkersCacheDataSource<M : Base.IgnorantMapper<M>> @Inject constructor(
    private val workersDao: WorkersDao,
    private val mapperIn: Base.Mapper<M, List<RoomWorkerModel>>,
    private val mapperOut: Base.Mapper<List<RoomWorkerModel>, M>,
) : WorkersCacheDataSource<M> {

    override suspend fun save(model: M) {
        workersDao.saveWorkers(
            model.map(mapperIn)
        )
    }

    override suspend fun get(): M =
        workersDao.getWorkers().let {
            if (it.isEmpty())
                throw NoCacheException()
            it
        }.let(mapperOut::map)
}