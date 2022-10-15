package com.example.kode.test_task.di.modules.ui.mappers

import dagger.Module

@Module(includes = [BUIWorkersMapperModule::class, BUIWorkerMapperModule::class])
interface BUIMapperModule