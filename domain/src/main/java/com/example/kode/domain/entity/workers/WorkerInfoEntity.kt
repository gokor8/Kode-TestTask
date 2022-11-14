package com.example.kode.domain.entity.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.sort.SortableUseCaseModel
import com.example.kode.domain.core.usecase.UseCaseModel

open class WorkerInfoEntity(
    val id: String,
    val avatarUrl: String,
    val name: String,
    val lastName: String,
    val userTag: String,
    val position: String
) : UseCaseModel, SortableUseCaseModel<String> {

    override fun isFit(sortModel: String) = position == sortModel
}