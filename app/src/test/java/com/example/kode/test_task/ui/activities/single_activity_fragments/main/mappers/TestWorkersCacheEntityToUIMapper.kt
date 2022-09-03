package com.example.kode.test_task.ui.activities.single_activity_fragments.main.mappers

import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.MainStatesUI
import com.example.kode.test_task.ui.activities.single_activity_fragments.main.models.WorkerInfoUIModel
import org.junit.Assert
import org.junit.Test

class TestWorkersCacheEntityToUIMapper {

    @Test
    fun `test mapping`() {
        val workerInfoEntityToUIMapper = WorkerInfoEntityToUIMapper()
        val mapper = WorkersCacheEntityToUIMapper(workerInfoEntityToUIMapper)

        val testDataModel = WorkersStateEntity.NoConnection(
            listOf(
                WorkerInfoEntity(
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
                WorkerInfoUIModel(
                    "avatar",
                    "name",
                    "lastName",
                    "userTag",
                    "position"
                )
            )
        )
        val actual = mapper.map(testDataModel)

        Assert.assertEquals(expected, actual)
    }
}