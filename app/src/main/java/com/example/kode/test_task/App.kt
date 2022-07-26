package com.example.kode.test_task

import android.app.Application
import com.example.kode.test_task.di.AppComponent
import com.example.kode.test_task.di.DaggerAppComponent
import io.realm.Realm
import io.realm.RealmConfiguration

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.factory().create(applicationContext, resources)

        Realm.init(this.applicationContext)
    }
}