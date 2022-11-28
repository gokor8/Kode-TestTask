package com.example.kode.domain.usecase.sort

import com.example.kode.domain.core.sort.SortableModel
import com.example.kode.domain.core.sort.SortableState

interface SortMapper<SM : SortableModel<SV>, SV : Any> {

    fun<SS : SortableState<SS, SM, SV>> map(sortableState: SS)
}