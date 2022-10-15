package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.ui.fail

import com.example.kode.domain.core.Base
import com.example.kode.test_task.databinding.FragmentWorkerBinding
import com.example.kode.test_task.di.annotations.worker_fragment.WorkerFragmentBinding
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import java.lang.ref.WeakReference
import javax.inject.Inject

class UIFatalErrorMapper @Inject constructor(
    @WorkerFragmentBinding
    private val binding: WeakReference<FragmentWorkerBinding>
) : Base.Mapper<WorkerStatesUI.FatalError, Unit> {

    override fun map(model: WorkerStatesUI.FatalError) {
        binding.get()?.vfMain?.showNext()
    }
}