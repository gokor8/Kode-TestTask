package com.example.kode.data.datasource.workers.cache

import android.util.Log
import com.example.kode.domain.core.Base
import io.realm.Realm
import io.realm.RealmObject
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.Executor
import java.util.concurrent.ThreadPoolExecutor
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.concurrent.thread

class RealmWorkersCacheDataSource<M : Any, RM : RealmObject> @Inject constructor(
    private val realm: Realm,
    private val realmModelClass: Class<RM>,
    private val mapperToRealmModel: Base.Mapper<M, MutableList<RM>>,
    private val mapperFromRealmModel: Base.Mapper<MutableList<RM>, M>
) : WorkersCacheDataSource<M> {

    private val dispatcher = Dispatchers.Default

    override suspend fun get(): M {
        Log.d("ThreadSee", "${Thread.currentThread()}")
        return realm.where(realmModelClass)
            .findAll()
            .let(mapperFromRealmModel::map)
    }

    override suspend fun save(model: M) {
        realm.executeTransactionAwait {
            Log.d("ThreadSee1", "${Thread.currentThread()}")
            it.insertOrUpdate(model.let(mapperToRealmModel::map))
        }
    }
}