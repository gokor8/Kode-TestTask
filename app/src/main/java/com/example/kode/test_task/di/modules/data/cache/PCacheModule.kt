package com.example.kode.test_task.di.modules.data.cache

import com.example.kode.data.datasource.workers.cache.realm.models.RealmWorkerModel
import dagger.Module
import dagger.Provides
import io.realm.Realm

@Module(includes = [PCacheRealmModule::class, PCacheRoomModule::class])
class PCacheModule