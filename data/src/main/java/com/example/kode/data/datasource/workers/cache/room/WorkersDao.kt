package com.example.kode.data.datasource.workers.cache.room

import androidx.room.*
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel

@Dao
interface WorkersDao {

    @Query("SELECT * FROM workers")
    suspend fun getWorkers(): List<RoomWorkerModel>

    @Query("SELECT * FROM workers WHERE id = :workerId")
    suspend fun getWorker(workerId: String): RoomWorkerModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveWorkers(workersList: List<RoomWorkerModel>)
}