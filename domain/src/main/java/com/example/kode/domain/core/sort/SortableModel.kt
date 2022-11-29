package com.example.kode.domain.core.sort

interface SortableModel<SV> : Comparable<SV> {

    fun sortValue(): SV

}