package com.example.kode.test_task.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import com.example.kode.test_task.databinding.ActivityMainBinding
import com.example.kode.test_task.ui.core.BaseActivity
import com.example.kode.test_task.ui.core.BaseViewModel

class SingleActivity : BaseActivity<ActivityMainBinding, BaseViewModel<*, *>>() {

    override val viewModel: BaseViewModel<*, *> by viewModels()

    override fun setBind(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun setUI() {
        setSupportActionBar()
    }
}