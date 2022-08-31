package com.example.kode.test_task.di.modules.data.cache

import android.content.Context
import androidx.room.Room
import com.example.kode.data.datasource.workers.cache.room.AppDatabase
import com.example.kode.data.datasource.workers.cache.room.workers.models.WorkersDao
import com.example.kode.test_task.di.annotations.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PCacheRoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "kode"
        ).build()

    @Singleton
    @Provides
    fun provideWorkersDao(database: AppDatabase): WorkersDao = database.workersDao()
}