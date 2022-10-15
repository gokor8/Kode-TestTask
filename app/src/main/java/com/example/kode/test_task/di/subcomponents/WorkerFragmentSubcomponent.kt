package com.example.kode.test_task.di.subcomponents

import com.example.kode.test_task.databinding.FragmentWorkerBinding
import com.example.kode.test_task.di.annotations.worker_fragment.WorkerFragmentBinding
import com.example.kode.test_task.di.modules.ui.mappers.BUIWorkerStateMapperModule
import com.example.kode.test_task.di.modules.ui.mappers.BUIWorkersStateMapperModule
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.WorkerFragment
import dagger.BindsInstance
import dagger.Subcomponent
import java.lang.ref.WeakReference

@Subcomponent(modules = [BUIWorkerStateMapperModule::class])
interface WorkerFragmentSubcomponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(
            @BindsInstance
            @WorkerFragmentBinding
            binding: WeakReference<FragmentWorkerBinding>,
        ): WorkerFragmentSubcomponent
    }

    fun inject(workerFragment: WorkerFragment)
}