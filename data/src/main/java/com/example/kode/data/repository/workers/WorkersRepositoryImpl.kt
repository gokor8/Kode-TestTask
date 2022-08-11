package com.example.kode.data.repository.workers

import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.data.datasource.workers.cloud.WorkersCloudDataSource
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import com.example.kode.domain.repository.WorkersRepository
import javax.inject.Inject

class WorkersRepositoryImpl<R : Any, M : Base.IgnorantMapper<M>> @Inject constructor(
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

/* Если надо будет сегодня-завтра поменять вывод с когда нету интернета
   то нужно будет всего лишь написать маппер другой для кеша и все
   сейчас стоит маппер на возвращение данных с ошибкой + данные с кеша
 */