package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.communications.temp_searchable.UISearchState

sealed interface MainStatesUI {

    sealed class Success(val workers: List<PreviewWorkerInfoUIModel>) : MainStatesUI {

        class Cloud(
            workers: List<PreviewWorkerInfoUIModel>,
        ) : Success(workers)

        class Cache(
            workers: List<PreviewWorkerInfoUIModel>,
        ) : Success(workers)

        class SearchSuccess(workers: List<PreviewWorkerInfoUIModel>) : Success(workers),
            UISearchState.Success
    }

    sealed class Fail : MainStatesUI {
        class UsualError(val errorId: Int) : Fail(), Base.IgnorantMapper<Int> {
            override fun <I : Base.Mapper<Int, R>, R> map(model: I): R = model.map(errorId)
        }

        class FatalError : Fail()

        class SearchNotFound : Fail(), UISearchState.Fail
    }
}