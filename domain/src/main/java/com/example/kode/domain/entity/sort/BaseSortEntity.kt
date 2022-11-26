package com.example.kode.domain.entity.sort

import com.example.kode.domain.core.sort.SortableModel
import com.example.kode.domain.core.sort.SortableState
import com.example.kode.domain.core.sort.UseCaseSortableModel

open class BaseSortEntity<SS : SortableState<SS, SM, SV>, SM : SortableModel<SV>, SV : Any>(
    val sortableValue: SV,
    val sortableModel: SS,
) : UseCaseSortableModel