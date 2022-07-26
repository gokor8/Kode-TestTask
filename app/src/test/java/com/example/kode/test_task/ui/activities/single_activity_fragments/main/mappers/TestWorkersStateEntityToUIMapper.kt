package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import org.junit.Assert
import org.junit.Test

class TestWorkersStateEntityToUIMapper {

    @Test
    fun `test success mapping`() {
        val entityMapper = WorkerInfoEntityToUIMapper()
        val successMapper = WorkerStateEntitySuccessToUIMapper(entityMapper)
        val failMapper = WorkerStateEntityFailToUIMapper()
        val mapper = WorkersStateEntityToUIMapper(successMapper, failMapper)

        val testData = WorkersStateEntity.Success(
            listOf(
                WorkerInfoEntity(
                    "test",
                    "test",
                    "test",
                    "test",
                    "test"
                )
            )
        )

        val actual = mapper.map(testData)

        Assert.assertTrue(actual is MainStatesUI.Success)
    }

    @Test
    fun `test fail generic mapping`() {
        val entityMapper = WorkerInfoEntityToUIMapper()
        val successMapper = WorkerStateEntitySuccessToUIMapper(entityMapper)
        val failMapper = WorkerStateEntityFailToUIMapper()
        val mapper = WorkersStateEntityToUIMapper(successMapper, failMapper)

        val testData = WorkersStateEntity.Fail(
            Exceptions.GenericException()
        )

        val actual = mapper.map(testData)

        Assert.assertTrue(actual is MainStatesUI.Fail)
    }
}