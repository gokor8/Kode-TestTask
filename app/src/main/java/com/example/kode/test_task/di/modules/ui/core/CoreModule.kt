package com.example.kode.test_task.di.modules.ui.core

import com.example.kode.test_task.ui.core.visibility_handler.BaseVisibilityHandler
import com.example.kode.test_task.ui.core.visibility_handler.VisibilityVGHandler
import dagger.Binds
import dagger.Module

@Module
interface CoreModule {

    @Binds
    fun bindVisibilityVGHandler(visibilityVGHandler: VisibilityVGHandler): BaseVisibilityHandler
}