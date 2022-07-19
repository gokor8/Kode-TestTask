package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test

class TestWorkersStateDataToEntityMapper {

    @Test
    fun `test success data model map`() {
        val workersSuccessDataToDomainMapper = WorkersSuccessDataToDomainMapper()
        val workersStateDataToEntityMapper =
            WorkersStateDataToEntityMapper(workersSuccessDataToDomainMapper)

        val workersDataModel = WorkersDataModel.Success(
            "test", "test", "test", "test"
        )

        val actual = workersStateDataToEntityMapper.map(workersDataModel)
        val expected = WorkersStateEntity.SuccessEntity(
            "test", "test", "test", "test"
        )

        Assert.assertEquals(expected, actual)
    }
}