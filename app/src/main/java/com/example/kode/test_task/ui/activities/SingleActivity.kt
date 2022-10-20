package com.example.kode.test_task.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.kode.test_task.R
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

    override fun onResume() = with(binding.iSearch) {
        super.onResume()
        etSearch.isFocusedByDefault = false
        tiSearch.isFocusedByDefault = false
        etSearch.clearFocus()
        tiSearch.clearFocus()
    }

    override fun setUI() {
        supportActionBar?.hide()
    }

    override fun setListeners() = with(binding.iSearch) {
        etSearch.setOnFocusChangeListener { _, hasFocus ->
            tiSearch.hint = if (!hasFocus) {
                tvCancel.isVisible = false
                resources.getString(R.string.main_tool_bar_hint)
            } else {
                tvCancel.isVisible = true
                ""
            }
        }

        tvCancel.setOnClickListener {
            etSearch.setText("")
            tvCancel.isVisible = false
        }
    }
}