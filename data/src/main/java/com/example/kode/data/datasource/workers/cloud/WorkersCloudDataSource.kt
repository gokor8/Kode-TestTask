package com.example.kode.data.datasource.workers.cloud

import com.example.kode.data.datasource.core.DataSource
import com.example.kode.domain.core.Read

interface WorkersCloudDataSource<R> : DataSource, Read.Abstract.Suspend<R>