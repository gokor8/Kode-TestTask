package com.example.kode.data.datasource.workers.cache.room.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Entity(tableName = "workers")
data class RoomWorkerModel(
    @PrimaryKey(autoGenerate = true)
    val roomId: Int = 0,
    val id: String?,
    val avatarUrl: String?,
    val name: String?,
    val lastName: String?,
    val userTag: String?,
    val department: String?,
    val position: String?,
    val birthday: String?,
    val phone: String?
)