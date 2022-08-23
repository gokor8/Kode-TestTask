package com.example.kode.domain.core.usecase

import com.example.kode.domain.core.Base

interface UseCaseModel<M : Any> : Base.IgnorantMapper<M>