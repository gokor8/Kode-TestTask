package com.example.kode.test_task

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration




class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Realm.init(this.applicationContext)
        /*val config = RealmConfiguration.Builder()
            .name("kode-test.realm")
            .schemaVersion(1)
            .deleteRealmIfMigrationNeeded()
            .build()
        Realm.setDefaultConfiguration(config)*/
    }
}