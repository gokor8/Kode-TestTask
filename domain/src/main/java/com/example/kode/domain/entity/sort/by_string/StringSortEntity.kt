package com.example.kode.domain.entity.sort.by_string

import com.example.kode.domain.core.sort.SortableState
import com.example.kode.domain.entity.sort.BaseSortEntity

class StringSortEntity<SS : SortableState<SS, SM, String>, SM : StringSortableModel>(
    sortableValue: String,
    sortableModel: SS
) : BaseSortEntity<SS, SM, String>(sortableValue, sortableModel)