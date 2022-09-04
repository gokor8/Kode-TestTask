package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import androidx.annotation.CallSuper
import com.example.kode.test_task.ui.core.recycler_view.BaseRecyclerViewAdapter

sealed interface MainStatesUI {

    sealed class Success(protected val workers: List<WorkerInfoUIModel>) : MainStatesUI{

        @CallSuper
        open fun setWorkers(adapter: BaseRecyclerViewAdapter<WorkerInfoUIModel, *, *>) {
            adapter.submitList(workers)
        }

        class Cloud(
            workers: List<WorkerInfoUIModel>
        ) : Success(workers)

        class Cache(
            workers: List<WorkerInfoUIModel>
        ) : Success(workers)
    }

    sealed class Fail : MainStatesUI {
        class UsualError(val errorId: Int) : Fail()

        class FatalError(val title: Int, val description: Int) : Fail()
    }
}