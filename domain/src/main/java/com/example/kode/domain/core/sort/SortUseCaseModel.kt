package com.example.kode.domain.core.sort

interface SortUseCaseModel<out RM : SortableUseCaseModel<*>> {

    fun sort(): List<RM>
}