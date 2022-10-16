package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers

import com.example.kode.domain.core.date_mappers.LocalDateToStringMapper
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import javax.inject.Inject

class WorkerLongLocalDateMapper @Inject constructor() : LocalDateToStringMapper(
    DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
) {
    private val replaceValue = " г."

    override fun map(model: LocalDate): String {
        return super.map(model).replace(replaceValue, "")
    }
}