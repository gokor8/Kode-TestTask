package com.example.kode.test_task.ui.core.visibility_handler

import android.view.View
import androidx.core.view.isVisible
import com.example.kode.test_task.ui.core.visibility.BaseVisibility

abstract class BaseVisibilityHandler(
    protected val visible: BaseVisibility,
    protected val gone: BaseVisibility
) : VisibilityHandler {

    override fun comboInverse(viewOn: View, vararg viewsOff: View): VisibilityHandler {
        visible.setVisibility(viewOn)
        viewsOff.forEach {
            gone.setVisibility(it)
        }

        return this
    }

    override fun inverse(view: View) =
        (if (view.isVisible) gone else visible).setVisibility(view)
}