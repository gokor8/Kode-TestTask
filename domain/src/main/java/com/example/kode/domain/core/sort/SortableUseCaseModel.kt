package com.example.kode.domain.core.sort

import com.example.kode.domain.core.usecase.UseCaseModel

interface SortableUseCaseModel<IM> : UseCaseModel {

    fun isFit(sortModel: IM): Boolean
}