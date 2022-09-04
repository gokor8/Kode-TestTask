package com.example.kode.test_task.di.modules.ui.recycler_views

import dagger.Module

@Module(includes = [BRecyclerViewModule::class, PRecyclerViewModule::class])
interface UnitedRecyclerViewModule