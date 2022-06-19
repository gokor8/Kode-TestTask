package com.example.kode.domain.repository

interface WorkersRepository<out R> {

    fun getWorkers(): R
}