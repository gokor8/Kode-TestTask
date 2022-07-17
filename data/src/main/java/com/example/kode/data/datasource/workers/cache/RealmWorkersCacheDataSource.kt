package com.example.kode.data.datasource.workers.cache

import com.example.kode.domain.core.Base
import io.realm.Realm
import io.realm.RealmObject
import io.realm.kotlin.executeTransactionAwait
import kotlinx.coroutines.Dispatchers

class RealmWorkersCacheDataSource<M : Base.IgnorantMapper<M>, RM : RealmObject> constructor(
    private val realm: Realm,
    private val getClass: Class<RM>,
    private val mapperToRealmModel: Base.Mapper<M, List<RM>>,
    private val mapperFromRealmModel: Base.Mapper<List<RM>, M>
) : WorkersCacheDataSource<M, M> {

    override suspend fun get(): M =
        realm.where(getClass)
            .findAll()
            .let(mapperFromRealmModel::map)

    override suspend fun save(model: M) {
        realm.executeTransactionAwait(Dispatchers.IO) {
            it.insert(model.map(mapperToRealmModel))
        }
    }
}