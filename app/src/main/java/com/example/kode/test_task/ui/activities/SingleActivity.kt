package com.example.kode.test_task.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.ActivityMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragment
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragmentArgs
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragmentDirections
import com.example.kode.test_task.ui.core.BaseActivity
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModel

class SingleActivity : BaseActivity<ActivityMainBinding, BaseViewModel<*, *>>() {

    override val viewModel: SingleActivityViewModel by viewModels()

    override fun setBind(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun setUI() {
        supportActionBar?.hide()
    }

    override fun setListeners() = with(binding.iSearch) {
        etSearch.setOnFocusChangeListener { _, hasFocus ->
            tiSearch.hint = if (!hasFocus && etSearch.text.isEmpty()) {
                tvCancel.isVisible = false
                resources.getString(R.string.main_tool_bar_hint)
            } else {
                tvCancel.isVisible = true
                ""
            }
        }

        etSearch.addTextChangedListener {
            tvCancel.isVisible = etSearch.text.isNotEmpty()
        }

        tvCancel.setOnClickListener {
            etSearch.setText("")
            tvCancel.isVisible = false
        }
    }

    override fun setObservers() = with(binding) {
        viewModel.observe(this@SingleActivity) {
            vpPositions.adapter = ScreenSlidePagerAdapter(this@SingleActivity, it)
        }
    }

    private inner class ScreenSlidePagerAdapter(
        fa: FragmentActivity,
        private val listPositions: List<String>,
    ) : FragmentStateAdapter(fa) {

        override fun getItemCount(): Int = listPositions.size

        override fun createFragment(position: Int): Fragment = MainFragment().apply {
            arguments = bundleOf("position" to listPositions[position])
        }
    }
}