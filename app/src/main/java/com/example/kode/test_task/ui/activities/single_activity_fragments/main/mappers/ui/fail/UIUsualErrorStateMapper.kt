package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail

import android.content.Context
import android.view.View
import com.example.kode.domain.core.Base
import com.example.kode.test_task.di.annotations.MainFragmentBinding
import com.example.kode.test_task.di.annotations.MainFragmentContext
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject

class UIUsualErrorStateMapper @Inject constructor(
    @MainFragmentContext
    private val context: Context,
    @MainFragmentBinding
    private val view: View
) : Base.Mapper<MainStatesUI.Fail.UsualError, Unit> {

    override fun map(model: MainStatesUI.Fail.UsualError) {
        Snackbar.make(
            view,
            context.resources.getString(model.errorId),
            Snackbar.LENGTH_LONG
        ).show()
    }
}