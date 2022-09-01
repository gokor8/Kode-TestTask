package com.example.kode.data.datasource.workers.cache.room

import com.example.kode.domain.core.Read

interface WorkerCacheDataSource<I, R> : Read.AbstractInput.SuspendEquable<I, R>