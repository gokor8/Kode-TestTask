package com.example.kode.data.workers

import com.example.kode.data.workers.cache.WorkersCacheDataSource
import com.example.kode.data.workers.cloud.WorkersCloudDataSource
import com.example.kode.data.workers.model.WorkersDataModel
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.custom_exceptions.NoConnectionException
import com.example.kode.domain.repository.WorkersRepository

class WorkersRepositoryImpl<R>(
    private val cloudDataSource: WorkersCloudDataSource<WorkersDataModel.Success>,
    private val cacheDataSource: WorkersCacheDataSource<WorkersDataModel.Success, WorkersDataModel.WithException>,
    private val mapper: Base.Mapper<WorkersDataModel, R>
) : WorkersRepository<R> {
    override fun getWorkers(): R {
        var data: WorkersDataModel
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