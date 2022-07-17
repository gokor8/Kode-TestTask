package com.example.kode.data.datasource.workers.cloud.service

import com.example.kode.domain.core.Base

interface WorkersService<R : Base.IgnorantMapper<R>> {

    fun getWorkers(): R
}