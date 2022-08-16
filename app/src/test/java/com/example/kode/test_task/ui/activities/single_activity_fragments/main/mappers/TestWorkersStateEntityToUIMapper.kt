package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.Exceptions
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import org.junit.Assert
import org.junit.Test

class TestWorkersStateEntityToUIMapper {

    private val entityMapper = WorkerInfoEntityToUIMapper()
    private val successMapper = WorkerStateEntitySuccessToUIMapper(entityMapper)
    private val noConnectionMapper = WorkerStateEntityNoConnectionToUIMapper(entityMapper)
    private val failMapper = WorkerStateEntityFailToUIMapper()

    @Test
    fun `test success mapping`() {
        val mapper = WorkersStateEntityToUIMapper(successMapper, noConnectionMapper, failMapper)

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

        val expected = MainStatesUI.Success(
            listOf(
                WorkerInfoUIModel(
                    "test",
                    "test",
                    "test",
                    "test",
                    "test"
                )
            )
        )
        val actual = mapper.map(testData)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `test no connection mapping`() {
        val mapper = WorkersStateEntityToUIMapper(successMapper, noConnectionMapper, failMapper)

        val testData = WorkersStateEntity.NoConnection(
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

        val expected = MainStatesUI.NoConnection(
            listOf(
                WorkerInfoUIModel(
                    "test",
                    "test",
                    "test",
                    "test",
                    "test"
                )
            )
        )
        val actual = mapper.map(testData)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `test fail generic mapping`() {
        val mapper = WorkersStateEntityToUIMapper(successMapper, noConnectionMapper, failMapper)

        val testData = WorkersStateEntity.Fail(
            Exceptions.GenericException
        )

        val actual = mapper.map(testData)

        Assert.assertTrue(actual is MainStatesUI.Fail)
    }
}