package com.example.kode.test_task.di.modules.domain

import com.example.kode.data.repository.workers.mappers.ExceptionToFailEntityMapper
import com.example.kode.domain.core.Base
import com.example.kode.domain.entity.workers.WorkersStateEntity
import dagger.Module
import dagger.Provides

@Module
class PMapperModule {

    @Provides
    fun provideExceptionToFailEntityMapper(): Base.Mapper<Exception, WorkersStateEntity> =
        ExceptionToFailEntityMapper()
}