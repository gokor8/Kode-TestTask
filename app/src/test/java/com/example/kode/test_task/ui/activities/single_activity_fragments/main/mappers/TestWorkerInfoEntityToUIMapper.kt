package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.WorkerInfoEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import org.junit.Assert
import org.junit.Test

class TestWorkerInfoEntityToUIMapper {

    @Test
    fun `test mapping`() {
        val mapper = WorkerInfoEntityToUIMapper()

        val testData = WorkerInfoEntity(
            "id",
            "avatarUrl",
            "name",
            "lastName",
            "userTag",
            "position"
        )

        val actual = mapper.map(testData)
        val expected = PreviewWorkerInfoUIModel(
            "id",
            "avatarUrl",
            "name",
            "lastName",
            "userTag",
            "position"
        )

        Assert.assertEquals(expected, actual)
    }
}