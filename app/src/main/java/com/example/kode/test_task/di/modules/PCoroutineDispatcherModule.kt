package com.example.kode.test_task.di.modules

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

@Module
class PCoroutineDispatcherModule {

  @Provides
  fun provideIODispatcher(): CoroutineContext = Dispatchers.IO
}