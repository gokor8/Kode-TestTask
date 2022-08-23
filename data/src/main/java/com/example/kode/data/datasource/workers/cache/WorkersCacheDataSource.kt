package com.example.kode.data.datasource.workers.cache

import com.example.kode.data.datasource.core.DataSource
import com.example.kode.domain.core.Read
import com.example.kode.domain.core.Save

interface WorkersCacheDataSource<M> : DataSource, Save.Suspend<M, Unit>, Read.Abstract.Suspend<M>