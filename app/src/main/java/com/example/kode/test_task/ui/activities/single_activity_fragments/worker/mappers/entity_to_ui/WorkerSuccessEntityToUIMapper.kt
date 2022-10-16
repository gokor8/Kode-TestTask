package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers.entity_to_ui

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.date_mappers.StringToLocalDateMapper
import com.example.kode.domain.entity.worker.WorkerFullStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.worker.models.WorkerStatesUI
import java.time.LocalDate
import javax.inject.Inject

class WorkerSuccessEntityToUIMapper @Inject constructor(
    private val stringToLocalDateMapper: Base.Mapper<String, LocalDate>,
    private val localDateToReadableStringMapper: Base.Mapper<LocalDate, String>,
    private val localDateToAgeMapper: Base.Mapper<LocalDate, Int>
    ) :
    Base.Mapper<WorkerFullStateEntity.Success, WorkerStatesUI.Success> {
    override fun map(model: WorkerFullStateEntity.Success) = with(model) {
        val localDateBirthday = stringToLocalDateMapper.map(birthday[0])

        WorkerStatesUI.Success(
            avatarUrl,
            firstName,
            lastName,
            userTag,
            department,
            position,
            localDateToReadableStringMapper.map(localDateBirthday),
            localDateToAgeMapper.map(localDateBirthday).toString(),
            phone
        )
    }
}