package com.example.kode.test_task.ui.core.visibility_handler

import com.example.kode.test_task.ui.core.visibility.BaseVisibility
import javax.inject.Inject

class VisibilityVGHandler @Inject constructor(
    visible: BaseVisibility.Visible,
    gone: BaseVisibility.Gone,
) : BaseVisibilityHandler(visible, gone)