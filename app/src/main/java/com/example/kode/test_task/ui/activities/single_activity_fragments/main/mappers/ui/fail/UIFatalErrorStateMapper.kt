package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.fail

import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.di.annotations.MainFragmentBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import javax.inject.Inject

class UIFatalErrorStateMapper @Inject constructor(
    private val binding: FragmentMainBinding
) : Base.Mapper<MainStatesUI.Fail.FatalError, Unit> {

    override fun map(model: MainStatesUI.Fail.FatalError) {
        binding.vfMain.showNext()
    }
}