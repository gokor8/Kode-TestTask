package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.ui.success

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.FragmentMainBinding
import com.example.kode.test_task.di.annotations.main_fragment.MainFragmentBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.MainFragment
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewRecyclerViewModel
import java.lang.ref.WeakReference
import javax.inject.Inject

class UISuccessToRecyclerPreviewModel @Inject constructor(
    private val binding: WeakReference<MainFragment>
) :
    Base.Mapper<MainResultStatesUI.Success, List<@JvmSuppressWildcards PreviewRecyclerViewModel>> {

    override fun map(model: MainResultStatesUI.Success): List<PreviewRecyclerViewModel> =
        model.workers.map { model ->
            with(model) {
                PreviewRecyclerViewModel(
                    id,
                    avatarUrl,
                    name,
                    lastName,
                    userTag,
                    position,
                    binding.get()!!.findNavController()
                )
            }
        }
}