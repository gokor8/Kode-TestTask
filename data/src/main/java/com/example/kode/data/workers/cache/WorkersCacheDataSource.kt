package com.example.kode.data.workers.cache

import com.example.kode.domain.core.Read
import com.example.kode.domain.core.Save

interface WorkersCacheDataSource<SM, R> : Save<SM, Unit>, Read.Base<R>