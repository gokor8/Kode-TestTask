package com.example.kode.domain.repository

interface WorkersRepository<R> {

    suspend fun getWorkers(): R
}