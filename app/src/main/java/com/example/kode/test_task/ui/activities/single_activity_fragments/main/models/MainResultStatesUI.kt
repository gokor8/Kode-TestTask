package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import com.example.kode.domain.core.Base
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.SearchResultStatesUI

sealed interface MainResultStatesUI : SearchResultStatesUI {

    class Initial(
        val skeletons: List<SkeletonWorkerUIModel> = List(12) { SkeletonWorkerUIModel() }
    ) : MainResultStatesUI

    sealed class Success(val workers: List<PreviewWorkerInfoUIModel>) : MainResultStatesUI {
        class Cloud(
            workers: List<PreviewWorkerInfoUIModel>,
        ) : Success(workers)

        class Cache(
            workers: List<PreviewWorkerInfoUIModel>,
        ) : Success(workers)

        class Search(
            workers: List<PreviewWorkerInfoUIModel>,
        ) : Success(workers)
    }

    sealed class Fail : MainResultStatesUI {
        class UsualError(val errorId: Int) : Fail(), Base.IgnorantMapper<Int> {
            override fun <I : Base.Mapper<Int, R>, R> map(model: I): R = model.map(errorId)
        }

        class SearchError : Fail()

        class FatalError : Fail()
    }
}