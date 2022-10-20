package com.example.kode.test_task.ui.activities

import android.widget.EditText
import com.example.kode.test_task.R

class TextInputLayoutHintHandler {

    fun observeHint(editText: EditText) {
        editText.setOnFocusChangeListener { v, hasFocus ->
            editText.hint = if (!hasFocus)
                editText.context.getString(R.string.main_tool_bar_hint) else ""
        }
    }
}