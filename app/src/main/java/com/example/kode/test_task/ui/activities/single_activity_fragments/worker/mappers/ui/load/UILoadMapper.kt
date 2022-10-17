package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.load

import androidx.core.view.isVisible
import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.FragmentWorkerBinding
import com.example.kode.test_task.di.annotations.worker_fragment.WorkerFragmentBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import java.lang.ref.WeakReference
import javax.inject.Inject

class UILoadMapper @Inject constructor(
    @WorkerFragmentBinding
    private val binding: WeakReference<FragmentWorkerBinding>
) : Base.Mapper<WorkerStatesUI.Load, Unit> {

    override fun map(model: WorkerStatesUI.Load) = binding.get()?.apply {
        val loadVisible = true

        pbLoad.isVisible = loadVisible
        llMain.isVisible = !loadVisible
        iError.llError.isVisible = !loadVisible
    }.let{}
}