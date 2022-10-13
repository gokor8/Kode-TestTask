package com.example.kode.data.datasource.workers.cache.room

import com.example.kode.data.datasource.core.DataSourceModel
import com.example.kode.data.datasource.workers.cache.room.models.RoomFindWorkerModel
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.domain.core.Base
import java.io.IOException
import javax.inject.Inject

class RoomWorkerCacheDataSource<IM : DataSourceModel<IM>, M> @Inject constructor(
    private val workersDao: WorkersDao,
    private val mapperIn: Base.Mapper<IM, RoomFindWorkerModel>,
    private val mapperOut: Base.Mapper<RoomWorkerModel, M>
) : WorkerCacheDataSource<IM, M> {

    override suspend fun get(equalsAttribute: IM): M =
        workersDao.getWorker(
            equalsAttribute.map(mapperIn).id
        )?.map(mapperOut) ?: throw IOException("there isnt user")
        // Вынести в кастомный класс ошибки
}