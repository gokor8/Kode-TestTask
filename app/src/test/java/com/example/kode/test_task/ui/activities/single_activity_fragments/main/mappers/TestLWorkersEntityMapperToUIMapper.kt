package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Test

class TestLWorkersEntityMapperToUIMapper {

    @Test
    fun `test success mapping`() {
        val mapper = LWorkersEntityMapperToUIMapper()
        val testData = listOf(
            WorkersStateEntity.Success(
                "test",
                "test",
                "test",
                "test",
                "test",
            ),
            WorkersStateEntity.Success(
                "test1",
                "test1",
                "test1",
                "test1",
                "test1",
            )
        )

        val actual = mapper.map(testData)
        val expected = listOf(
            WorkersStateEntity.Success(
                "test",
                "test",
                "test",
                "test",
                "test",
            ),
            WorkersStateEntity.Success(
                "test1",
                "test1",
                "test1",
                "test1",
                "test1",
            )
        )

    }
}