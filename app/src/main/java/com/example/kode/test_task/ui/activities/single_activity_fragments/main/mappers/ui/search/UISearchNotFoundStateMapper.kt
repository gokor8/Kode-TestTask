package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.search

import androidx.core.view.isVisible
import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainSearchStates
import java.lang.ref.WeakReference
import javax.inject.Inject

class UISearchNotFoundStateMapper @Inject constructor(
    @MainFragmentBinding
    private val binding: WeakReference<FragmentMainBinding>,
) : Base.Mapper<MainSearchStates.SearchNotFound, Unit> {

    override fun map(model: MainSearchStates.SearchNotFound) {
        binding.get()?.llSearchError?.isVisible = true
        binding.get()?.rvMain?.isVisible = false
    }
}