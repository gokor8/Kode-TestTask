package com.example.kode.test_task.di

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.mappers.StringToSingleActivityStateMapper
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import dagger.Module
import dagger.Provides

@Module
class HelpModule {

    @Provides
    fun provideStringToSingleActivityStateMapper(): Base.Mapper<String, SingleActivityStatesUI> {
        return StringToSingleActivityStateMapper()
    }
}