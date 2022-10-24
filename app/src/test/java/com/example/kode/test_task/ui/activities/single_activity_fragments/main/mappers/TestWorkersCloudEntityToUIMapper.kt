package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.WorkerInfoEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers.entity_to_ui.WorkersCloudEntityToUIMapper
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainResultStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.PreviewWorkerInfoUIModel
import org.junit.Assert
import org.junit.Test

class TestWorkersCloudEntityToUIMapper {

    @Test
    fun `test mapping`() {
        val workerInfoEntityToUIMapper = WorkerInfoEntityToUIMapper()
        val mapper = WorkersCloudEntityToUIMapper(workerInfoEntityToUIMapper)

        val testDataModel = WorkersStateEntity.Success(
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

        val actual = mapper.map(testDataModel)
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

        Assert.assertEquals(expected, actual)
    }
}