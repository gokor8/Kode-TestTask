package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.search

import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import com.example.kode.test_task.ui.core.visibility_handler.VisibilityVGHandler
import java.lang.ref.WeakReference
import javax.inject.Inject

class UISearchNotFoundStateMapper @Inject constructor(
    @MainFragmentBinding
    private val binding: WeakReference<FragmentMainBinding>,
    private val visibilityVGHandler: VisibilityVGHandler,
) : Base.Mapper<MainSearchStates.SearchNotFound, Unit> {

    override fun map(model: MainSearchStates.SearchNotFound) {
        binding.get()?.apply {
            visibilityVGHandler.comboInverse(llSearchError, rvMain)
        }
    }
}