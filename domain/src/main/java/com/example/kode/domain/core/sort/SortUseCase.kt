package com.example.kode.domain.core.sort

import com.example.kode.domain.core.Read
import com.example.kode.domain.core.usecase.UseCaseModel

interface SortUseCase<SM : UseCaseSortableModel, M : UseCaseModel> :
    Read.AbstractInput.SuspendEquable<SM, M>