package com.example.kode.data.datasource.workers.cache.room

import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.room.mappers.`in`.WorkersDataStateMapper
import com.example.kode.data.datasource.workers.cache.room.mappers.out.LRoomToWorkersCacheDataStateMapper
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
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
        workersDao.getWorkers().let(mapperOut::map)
}