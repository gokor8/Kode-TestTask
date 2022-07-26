package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import org.junit.Assert
import org.junit.Test

class TestWorkerStateEntitySuccessToUIMapper {

    @Test
    fun `test mapping`() {
        val workerInfoEntityToUIMapper = WorkerInfoEntityToUIMapper()
        val mapper = WorkerStateEntitySuccessToUIMapper(workerInfoEntityToUIMapper)

        val testDataModel = WorkersStateEntity.Success(
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

        val actual = mapper.map(testDataModel)
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

        Assert.assertEquals(expected, actual)
    }
}