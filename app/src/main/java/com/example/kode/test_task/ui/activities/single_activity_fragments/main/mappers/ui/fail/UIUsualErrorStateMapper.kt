package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail

import android.content.Context
import android.view.View
import com.example.kode.domain.core.Base
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentContext
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentView
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.google.android.material.snackbar.Snackbar
import java.lang.ref.WeakReference
import javax.inject.Inject

class UIUsualErrorStateMapper @Inject constructor(
    @MainFragmentContext
    private val context: WeakReference<Context>,
    @MainFragmentView
    private val view: WeakReference<View>
) : Base.Mapper<MainStatesUI.Fail.UsualError, Unit> {

    override fun map(model: MainStatesUI.Fail.UsualError) {
        Snackbar.make(
            view.get() ?: return,
            context.get()?.resources?.getString(model.errorId) ?: return,
            Snackbar.LENGTH_LONG
        ).show()
    }
}