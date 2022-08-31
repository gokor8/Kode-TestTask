package com.example.kode.data.datasource.core.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.datasource.workers.cache.room.WorkersDao

@Database(entities = [RoomWorkerModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workersDao(): WorkersDao
}