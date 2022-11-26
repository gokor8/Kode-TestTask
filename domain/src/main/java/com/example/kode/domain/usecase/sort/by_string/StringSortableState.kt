package com.example.kode.domain.usecase.sort.by_string

import com.example.kode.domain.core.sort.SortableState

interface StringSortableState<SS : StringSortableState<SS, SM>, SM : StringSortableModel>
    : SortableState<SS, SM, String>