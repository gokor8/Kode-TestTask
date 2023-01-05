package com.example.kode.domain.entity.sort.by_string

import com.example.kode.domain.core.sort.SortableState
import com.example.kode.domain.entity.sort.BaseSortEntity

class StringSortEntity<SS : SortableState<SS, SM>, SM : StringSortableModel>(
    sortableValue: @JvmSuppressWildcards String,
    sortableModel: SS
) : BaseSortEntity<SS, SM, String>(sortableValue, sortableModel)