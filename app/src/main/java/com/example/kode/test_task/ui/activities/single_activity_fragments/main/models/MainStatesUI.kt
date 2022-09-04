package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import com.example.kode.domain.core.Base

sealed interface MainStatesUI {

    sealed class Success(val workers: List<WorkerInfoUIModel>) :
        MainStatesUI {

        class Cloud(
            workers: List<WorkerInfoUIModel>,
        ) : Success(workers)

        class Cache(
            workers: List<WorkerInfoUIModel>,
        ) : Success(workers)
    }

    sealed class Fail : MainStatesUI {
        class UsualError(val errorId: Int) : Fail(), Base.IgnorantMapper<Int> {
            override fun <I : Base.Mapper<Int, R>, R> map(model: I): R = model.map(errorId)
        }

        class FatalError : Fail()
    }
}