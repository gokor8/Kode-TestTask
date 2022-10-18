package com.example.kode.test_task.ui.core.visibility_handler

import android.view.View

interface VisibilityHandler {

    fun comboInverse(viewOn: View, vararg viewsOff: View): VisibilityHandler

    fun inverse(view: View)
}