package com.example.kode.data.datasource.workers.cache

import com.example.kode.domain.core.Read
import com.example.kode.domain.core.Save

interface WorkersCacheDataSource<I, R> : Save<I, Unit>, Read.Base<R>