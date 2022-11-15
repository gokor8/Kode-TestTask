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
import com.example.kode.test_task.App
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.ActivityMainBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragment
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragmentArgs
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragmentDirections
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainViewModelFactory
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.core.BaseActivity
import com.example.kode.test_task.ui.core.viewmodels.BaseViewModel
import java.lang.ref.WeakReference
import javax.inject.Inject

class SingleActivity : BaseActivity<ActivityMainBinding, BaseViewModel<*, *>>() {

    @Inject
    lateinit var viewModelFactory: SingleActivityViewModelFactory

    override val viewModel: SingleActivityViewModel by viewModels{ viewModelFactory }

    override fun setBind(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun setUI() {
        (application as App).daggerAppComponent.inject(this)
        supportActionBar?.hide()
        viewModel.getPositions()
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