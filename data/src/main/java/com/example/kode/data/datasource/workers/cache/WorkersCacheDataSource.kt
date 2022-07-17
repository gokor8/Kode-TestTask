package com.example.kode.data.datasource.workers.cache

import com.example.kode.domain.core.Read
import com.example.kode.domain.core.Save

interface WorkersCacheDataSource<I, R> : Save.Suspend<I, Unit>, Read.Suspend<R>