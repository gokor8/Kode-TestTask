package com.example.kode.domain.core.sort

import com.example.kode.domain.core.Read

interface SortUseCase<SM : SortModel, M> : Read.AbstractInput.SuspendEquable<SM, M>