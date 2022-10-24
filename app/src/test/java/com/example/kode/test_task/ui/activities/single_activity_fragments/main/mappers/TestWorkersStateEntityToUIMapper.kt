package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.*
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import org.junit.Assert
import org.junit.Test

class TestWorkersStateEntityToUIMapper {

    private val entityMapper = WorkerInfoEntityToUIMapper()
    private val successMapper = WorkersCloudEntityToUIMapper(entityMapper)
    private val noConnectionMapper = WorkersCacheEntityToUIMapper(entityMapper)
    private val failMapper = WorkersFailEntityToUIMapper()

    @Test
    fun `test success cloud mapping`() {
        val mapper = WorkersStateEntityToUIMapper(successMapper, noConnectionMapper, failMapper)

        val testData = WorkersStateEntity.Success(
            listOf(
                WorkerInfoEntity(
                    "id",
                    "avatar",
                    "name",
                    "lastName",
                    "userTag",
                    "position"
                )
            )
        )

        val expected = MainResultStatesUI.Success.Cloud(
            listOf(
                PreviewWorkerInfoUIModel(
                    "id",
                    "avatar",
                    "name",
                    "lastName",
                    "userTag",
                    "position"
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
                    "id",
                    "avatar",
                    "name",
                    "lastName",
                    "userTag",
                    "position"
                )
            )
        )

        val expected = MainResultStatesUI.Success.Cache(
            listOf(
                PreviewWorkerInfoUIModel(
                    "id",
                    "avatar",
                    "name",
                    "lastName",
                    "userTag",
                    "position"
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
            UseCaseExceptions.GenericException
        )

        val actual = mapper.map(testData)

        Assert.assertTrue(actual is MainResultStatesUI.Fail)
    }
}