package com.example.kode.domain.core.usecase

import com.example.kode.domain.core.Read

interface UseCaseInput<I : Any, R : UseCaseModel<R>> : Read.AbstractInput.SuspendEquable<I, R>