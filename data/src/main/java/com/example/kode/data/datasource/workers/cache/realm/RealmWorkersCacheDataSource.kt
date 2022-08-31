package com.example.kode.data.datasource.workers.cache.realm

import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.domain.core.Base
import io.realm.Realm
import io.realm.RealmObject
import io.realm.kotlin.executeTransactionAwait
import javax.inject.Inject

class RealmWorkersCacheDataSource<M : Any, RM : RealmObject> @Inject constructor(
    private val realm: Realm,
    private val realmModelClass: Class<RM>,
    private val mapperToRealmModel: Base.Mapper<M, MutableList<RM>>,
    private val mapperFromRealmModel: Base.Mapper<MutableList<RM>, M>
) : WorkersCacheDataSource<M> {

    override suspend fun get(): M {
        return realm.where(realmModelClass)
            .findAll()
            .let(mapperFromRealmModel::map)
    }

    override suspend fun save(model: M) {
        realm.executeTransactionAwait {
            it.insertOrUpdate(model.let(mapperToRealmModel::map))
        }
    }
}