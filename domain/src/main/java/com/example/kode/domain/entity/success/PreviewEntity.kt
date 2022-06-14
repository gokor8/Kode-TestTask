package com.example.kode.domain.entity.success

import com.example.kode.domain.core.BaseState

data class PreviewEntity(
    val name: String,
    val lastName: String,
    val userTag: String,
    val position: String
) : BaseState.Success