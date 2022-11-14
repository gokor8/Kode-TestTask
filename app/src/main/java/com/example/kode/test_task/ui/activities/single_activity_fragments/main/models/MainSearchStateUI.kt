package com.example.kode.test_task.ui.activities.single_activity_fragments.main.models

import com.example.kode.domain.core.sort.FilterableCreator
import com.example.kode.domain.core.sort.EmptyFilterableUseCaseModel
import com.example.kode.domain.core.sort.FilterableUseCaseModel
import com.example.kode.domain.entity.workers.WorkerSortableEntity
import com.example.kode.domain.entity.workers.WorkerSortableNameEntity
import com.example.kode.domain.entity.workers.WorkerSortableNickEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.searchable.models.SearchResultStatesUI

sealed class MainSearchStateUI : SearchResultStatesUI{

    sealed class SearchUI<SM : WorkerSortableEntity>(val text: String) :
        MainSearchStateUI(), FilterableCreator<PreviewWorkerInfoUIModel, SM> {

        override fun createFilterable(toSortList: List<PreviewWorkerInfoUIModel>) =
            FilterableUseCaseModel(text, getSortableModels(toSortList))

        protected abstract fun getSortableModels(toSortList: List<PreviewWorkerInfoUIModel>): List<SM>
    }

    open class FullName(text: String) : SearchUI<WorkerSortableNameEntity>(text) {

        // Может маппер сюда кинуть?
        override fun getSortableModels(
            toSortList: List<PreviewWorkerInfoUIModel>,
        ): List<WorkerSortableNameEntity> =
            toSortList.map {
                WorkerSortableNameEntity(
                    it.id, it.avatarUrl, it.name, it.lastName, it.userTag, it.position
                )
            }
    }

    class NickName(text: String) : SearchUI<WorkerSortableNickEntity>(text) {

        override fun getSortableModels(
            toSortList: List<PreviewWorkerInfoUIModel>,
        ): List<WorkerSortableNickEntity> =
            toSortList.map {
                WorkerSortableNickEntity(
                    it.id, it.avatarUrl, it.name, it.lastName, it.userTag, it.position
                )
            }
    }

    class Cancel : MainSearchStateUI()
}