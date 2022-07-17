package com.example.kode.data.datasource.workers.cache

import com.example.kode.data.datasource.workers.cache.models.RealmWorkersModel
import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.core.Base
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import okhttp3.Dispatcher

class RealmWorkersCacheDataSource<M : Base.IgnorantMapper<M>> constructor(
    private val realm: Realm
    private val mapperToRealmModel: Base.Mapper<M, RealmWorkersModel>
) : WorkersCacheDataSource<WorkersDataModel, WorkersDataModel> {

    override fun get(): WorkersDataModel {

    }

    override suspend fun save(model: M) {
        realm.executeTransactionAwait(Dispatchers.IO) {
            it.insert(model.map(mapperToRealmModel))
        }
    }
}