package com.example.kode.test_task.di.modules.domain

import com.example.kode.data.repository.workers.mappers.ExceptionToFailEntityMapper
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import dagger.Binds
import dagger.Module

@Module
interface BMapperModule {

    @Binds
    fun bindExceptionToFailEntityMapper(mapper: ExceptionToFailEntityMapper)
            : Base.Mapper<Exception, WorkersStateEntity>
}
