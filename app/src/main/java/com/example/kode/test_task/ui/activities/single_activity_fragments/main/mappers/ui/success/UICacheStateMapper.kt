package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success

import android.content.Context
import android.view.View
import com.example.kode.test_task.R
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.databinding.ItemMainBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentContext
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentView
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.recycler_view.MainViewHolder
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter
import com.example.kode.test_task.ui.core.visibility_handler.VisibilityVGHandler
import com.google.android.material.snackbar.Snackbar
import java.lang.ref.WeakReference
import javax.inject.Inject

class UICacheStateMapper @Inject constructor(
    @MainFragmentContext
    private val context: WeakReference<Context>,
    @MainFragmentBinding
    binding: WeakReference<FragmentMainBinding>,
    visibilityVGHandler: VisibilityVGHandler,
    adapter: BaseRecyclerViewAdapter<PreviewWorkerInfoUIModel, ItemMainBinding, MainViewHolder>
) : UISuccessMapper<MainStatesUI.Success.Cache>(adapter, binding, visibilityVGHandler) {

    override fun map(model: MainStatesUI.Success.Cache) = binding.get()?.also {
        super.map(model)

        Snackbar.make(
            it.root,
            context.get()?.resources?.getString(R.string.no_connection) ?: return@also,
            Snackbar.LENGTH_LONG
        ).show()
    }.let {}
}