package com.example.kode.test_task.ui.activities.mappers

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.models.SingleActivityStatesUI
import javax.inject.Inject

class StringToSingleActivityStateMapper @Inject constructor() :
    Base.Mapper<String, SingleActivityStatesUI> {

    override fun map(model: String): SingleActivityStatesUI =
        if (model.isNotEmpty())
            SingleActivityStatesUI.Search(model)
        else
            SingleActivityStatesUI.Cancel()
}