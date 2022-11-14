package com.example.kode.domain.core.sort

// Говна, сделать по нормальнмоу с копированием состояния, и передачи состояния а не списка
class EmptyFilterableUseCaseModel<RM : SortableUseCaseModel<*>> : SortUseCaseModel<RM> {

    override fun sort(): List<RM> = emptyList()
}