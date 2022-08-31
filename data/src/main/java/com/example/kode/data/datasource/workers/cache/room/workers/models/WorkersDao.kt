package com.example.kode.data.datasource.workers.cache.room.workers.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.kode.data.datasource.workers.cache.room.workers.models.RoomWorkerModel

@Dao
interface WorkersDao {

    @Query("SELECT * FROM workers")
    suspend fun getWorkers(): List<RoomWorkerModel>

    @Query("SELECT * FROM workers WHERE id = :workerId")
    suspend fun getWorker(workerId: String): RoomWorkerModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWorkers(workersList: List<RoomWorkerModel>)
}