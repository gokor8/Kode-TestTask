package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import org.junit.Assert
import org.junit.Test

class TestWorkerInfoEntityToUIMapper {

    @Test
    fun `test mapping`() {
        val mapper = WorkerInfoEntityToUIMapper()

        val testData = WorkerInfoEntity(
            "test",
            "test",
            "test",
            "test",
            "test"
        )

        val actual = mapper.map(testData)
        val expected = WorkerInfoUIModel(
            "test",
            "test",
            "test",
            "test",
            "test",
        )

        Assert.assertEquals(expected, actual)
    }
}