package com.example.kode.data.workers.cloud

data class WorkersResponse(
    val id: String,
    val avatarUrl: String,
    val firstName: String,
    val lastName: String,
    val userTag: String,
    val department: String,
    val position: String,
    val birthday: List<String>,
    val phone: String
)