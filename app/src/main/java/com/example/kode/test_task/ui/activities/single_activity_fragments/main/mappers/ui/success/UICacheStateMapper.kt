package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success

import android.content.Context
import android.view.View
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentContext
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentView
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import com.google.android.material.snackbar.Snackbar
import java.lang.ref.WeakReference
import javax.inject.Inject

class UICacheStateMapper @Inject constructor(
    @MainFragmentContext
    private val context: WeakReference<Context>,
    @MainFragmentView
    private val view: WeakReference<View>,
    adapter: BaseRecyclerViewAdapter<WorkerInfoUIModel, ItemMainBinding, MainViewHolder>
) : UISuccessMapper<MainStatesUI.Success.Cache>(adapter) {

    override fun map(model: MainStatesUI.Success.Cache) {
        super.map(model)

        Snackbar.make(
            view.get() ?: return,
            context.get()?.resources?.getString(R.string.no_connection) ?: return,
            Snackbar.LENGTH_LONG
        ).show()
    }
}