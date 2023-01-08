package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.*
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.fail.WorkersFailEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.success.WorkersCacheEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.success.WorkersCloudEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.success.WorkersSuccessEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import org.junit.Assert
import org.junit.Test

class TestWorkersStateEntityToUIMapper {

    private val entityMapper = WorkerInfoEntityToUIMapper()
    private val successMapper = WorkersSuccessEntityToUIMapper(
        WorkersCloudEntityToUIMapper(entityMapper),
        WorkersCacheEntityToUIMapper(entityMapper)
    )
    private val failMapper = WorkersFailEntityToUIMapper()
    private val mapper = WorkersStateEntityToUIMapper(successMapper, failMapper)

    @Test
    fun `test success cloud mapping`() {
        val testData = WorkersStateEntity.WithConnection(
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

        val expected = MainStatesUI.Success.Cloud(
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

        val expected = MainStatesUI.Success.Cache(
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
        val testData = WorkersStateEntity.Fail(
            UseCaseExceptions.GenericException
        )

        val actual = mapper.map(testData)

        Assert.assertTrue(actual is MainStatesUI.Fail)
    }
}