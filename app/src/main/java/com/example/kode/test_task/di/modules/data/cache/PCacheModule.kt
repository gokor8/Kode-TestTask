package com.example.kode.test_task.di.modules.data.cache

import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module
class PCacheModule {

    @Provides
    fun provideRealm(): Realm = Realm.getDefaultInstance()

    @Provides
    fun provideRealmModelClass(): Class<RealmWorkerModel> = RealmWorkerModel::class.java
}