package com.example.kode.test_task.di.modules.ui.mappers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.date_mappers.StringToLocalDateMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.WorkerLocalDateToAgeMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.WorkerLongLocalDateMapper
import dagger.Binds
import dagger.Module
import java.time.LocalDate

@Module(includes = [BUIWorkersMapperModule::class, BUIWorkersSearchStateMapperModule::class,
    BUIWorkerMapperModule::class])
interface BUIMapperModule {

    @Binds
    fun bindStringToLocalDateMapper(mapper: StringToLocalDateMapper)
            : Base.Mapper<String, LocalDate>

    @Binds
    fun bindLocalDateToAgeMapper(mapper: WorkerLocalDateToAgeMapper)
            : Base.Mapper<LocalDate, Int>

    @Binds
    fun bindWorkerLongLocalDateMapper(mapper: WorkerLongLocalDateMapper)
            : Base.Mapper<LocalDate, String>
}