package com.example.kode.test_task.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class PCoroutineDispatcherModule {

  @Provides
  fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}