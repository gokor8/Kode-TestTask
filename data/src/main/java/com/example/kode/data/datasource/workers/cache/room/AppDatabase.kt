package com.example.kode.data.datasource.workers.cache.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kode.data.datasource.workers.cache.room.workers.models.RoomWorkerModel
import com.example.kode.data.datasource.workers.cache.room.workers.models.WorkersDao

@Database(entities = [RoomWorkerModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun workersDao(): WorkersDao
}