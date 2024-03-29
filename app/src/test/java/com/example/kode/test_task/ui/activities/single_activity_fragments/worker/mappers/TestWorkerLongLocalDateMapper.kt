package com.example.kode.test_task.ui.activities.single_activity_fragments.worker.mappers

import org.junit.Assert
import org.junit.Test
import java.time.LocalDate

class TestWorkerLongLocalDateMapper {

    private val mapper = WorkerLongLocalDateMapper()

    @Test
    fun `success mapping`() {
        val testDate = LocalDate.of(2004,8, 2)

        val actual = mapper.map(testDate)
        val expected = "2 августа 2004"

        Assert.assertEquals(expected, actual)
    }
}