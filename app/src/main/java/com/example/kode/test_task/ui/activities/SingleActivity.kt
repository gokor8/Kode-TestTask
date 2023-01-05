package com.example.kode.test_task.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.FragmentActivity
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.ActivityMainBinding
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.WorkerViewModelFactory
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import com.example.kode.test_task.ui.core.BaseActivity
import com.example.kode.test_task.ui.core.view_model.BaseViewModel
import java.lang.ref.WeakReference
import javax.inject.Inject

class SingleActivity : BaseActivity<ActivityMainBinding, SingleActivityViewModel<SingleActivityStatesUI>>() {

    @Inject
    lateinit var viewModelFactory: SingleActivityViewModelFactory<SingleActivityStatesUI>

    override val viewModel: SingleActivityViewModel<SingleActivityStatesUI> by viewModels { viewModelFactory }

    override fun setBind(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        provideApp().daggerAppComponent.inject(this)
    }

    override fun onResume() = with(binding.iSearch) {
        super.onResume()
        etSearch.isFocusedByDefault = false
        tilSearch.isFocusedByDefault = false
        etSearch.clearFocus()
        tilSearch.clearFocus()
    }

    override fun setUI() {
        supportActionBar?.hide()
    }

    override fun setListeners() = with(binding.iSearch) {
        etSearch.doOnTextChanged { text, _, _, _ ->
            tvCancel.isVisible = text == null || text.isEmpty()

            viewModel.setSearchText(text.toString())
        }

        etSearch.setOnFocusChangeListener { _, isFocused ->
            tilSearch.hint = if (isFocused && etSearch.text.isNotEmpty()) {
                ""
            } else {
                resources.getString(R.string.main_tool_bar_hint)
            }
        }

        tvCancel.setOnClickListener {
            etSearch.setText("")
            tvCancel.isVisible = false
        }
    }

    override fun requireActivity(): FragmentActivity {
        return this
    }
}