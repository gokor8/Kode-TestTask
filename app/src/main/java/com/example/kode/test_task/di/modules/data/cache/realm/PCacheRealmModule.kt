package com.example.kode.test_task.di.modules.data.cache.realm

import com.example.kode.data.datasource.workers.cache.realm.models.RealmWorkerModel
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class PCacheRealmModule {

    @Provides
    fun provideRealm(): Realm = Realm.getDefaultInstance()

    @Provides
    fun provideRealmModelClass(): Class<RealmWorkerModel> = RealmWorkerModel::class.java
}