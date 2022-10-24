package com.example.kode.test_task.ui.core.fragments

import androidx.appcompat.app.AppCompatActivity

interface ProvideAppCompatActivity {
    fun<A : AppCompatActivity> provideActivity(): A
}