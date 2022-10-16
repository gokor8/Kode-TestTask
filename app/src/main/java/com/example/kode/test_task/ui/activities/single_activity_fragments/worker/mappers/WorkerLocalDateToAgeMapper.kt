package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers

import com.example.kode.domain.core.Base
import java.time.LocalDate
import javax.inject.Inject

class WorkerLocalDateToAgeMapper @Inject constructor() : Base.Mapper<LocalDate, Int> {

    private val currentDate = LocalDate.now()

    override fun map(model: LocalDate) = currentDate.year - model.year
}