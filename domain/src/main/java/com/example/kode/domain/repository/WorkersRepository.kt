package com.example.kode.domain.repository

interface WorkersRepository<out R> {

    suspend fun getWorkers(): R
}