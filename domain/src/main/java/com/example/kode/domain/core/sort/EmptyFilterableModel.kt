package com.example.kode.domain.core.sort

class EmptyFilterableModel : SortableUseCaseModel<Any> {
    override fun isFit(sortModel: Any): Boolean = true
}