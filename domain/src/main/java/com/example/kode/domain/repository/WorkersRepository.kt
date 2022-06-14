package com.example.kode.domain.repository

import com.example.kode.domain.core.BaseState

interface WorkersRepository {

    fun getWorkers() : BaseState
}