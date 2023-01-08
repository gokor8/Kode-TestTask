package com.example.kode.test_task.ui.core.search

import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding
import com.example.kode.test_task.ui.activities.SingleActivityViewModel
import com.example.kode.test_task.ui.core.BaseActivity
import com.example.kode.test_task.ui.core.BaseFragment
import com.example.kode.test_task.ui.core.view_model.BaseViewModel

typealias SingleActivity<SM> = BaseActivity<*, SingleActivityViewModel<SM>>

abstract class SearchFragment<VB : ViewBinding, VM : SearchViewModel<*, *, *, SM>, SM : Any>
    : BaseFragment<VB, VM>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSearch()
    }

    protected fun setSearch() {
        provide<SingleActivity<SM>>().viewModel.observe(viewLifecycleOwner) {
            viewModel.search(it)
        }
    }
}