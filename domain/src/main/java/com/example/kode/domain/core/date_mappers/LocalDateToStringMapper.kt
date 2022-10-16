package com.example.kode.domain.core.date_mappers

import com.example.kode.domain.core.Base
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

open class LocalDateToStringMapper @Inject constructor(
    private val dateTimeFormatter: DateTimeFormatter
) : Base.Mapper<LocalDate, String> {

    override fun map(model: LocalDate): String = model.format(dateTimeFormatter)
}