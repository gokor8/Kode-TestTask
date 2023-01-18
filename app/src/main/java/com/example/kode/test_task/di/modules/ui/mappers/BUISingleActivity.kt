package com.example.kode.test_task.di.modules.ui.mappers

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.mappers.StringToSingleActivityStateMapper
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import dagger.Binds
import dagger.Module

@Module
interface BUISingleActivity {

    @Binds
    fun bindStringToSingleActivityStateMapper(mapper: StringToSingleActivityStateMapper)
            : Base.Mapper<String, SingleActivityStatesUI>
}