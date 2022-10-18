package com.example.kode.test_task.ui.core.visibility

import android.view.View
import javax.inject.Inject

sealed class BaseVisibility(private val visibility: Int) : Visibility {
    
    override fun setVisibility(view: View) {
        view.visibility = visibility    
    }

    class Visible @Inject constructor() : BaseVisibility(View.VISIBLE)
    class Invisible @Inject constructor() : BaseVisibility(View.INVISIBLE)
    class Gone @Inject constructor() : BaseVisibility(View.GONE)
}