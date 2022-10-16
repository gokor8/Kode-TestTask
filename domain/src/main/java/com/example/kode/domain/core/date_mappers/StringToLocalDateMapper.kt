package com.example.kode.domain.core.date_mappers

import com.example.kode.domain.core.Base
import java.time.LocalDate
import javax.inject.Inject

class StringToLocalDateMapper @Inject constructor() : Base.Mapper<String, LocalDate> {

    override fun map(model: String) = LocalDate.parse(model)
}