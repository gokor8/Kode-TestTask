package com.example.kode.test_task.ui.core.fragments

import android.app.Application

interface ProvideApp {
    fun<A : Application> provideApp(): A
}