package com.example.kode.data.datasource.workers.cache.room

import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.domain.core.Base
import java.io.IOException
import javax.inject.Inject

class RoomWorkerCacheDataSource<M> @Inject constructor(
    private val workersDao: WorkersDao,
    private val mapperOut: Base.Mapper<RoomWorkerModel, M>
) : WorkerCacheDataSource<String, M> {

    override suspend fun get(equalsAttribute: String): M =
        workersDao.getWorker(equalsAttribute)?.map(mapperOut)
            ?: throw IOException("there isnt user")
        // Вынести в кастомный класс ошибки
}