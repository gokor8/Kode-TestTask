package com.example.kode.data.repository.workers.mappers

import com.example.kode.data.repository.workers.models.WorkersDataModel
import com.example.kode.domain.entity.workers.WorkersEntity
import org.junit.Assert
import org.junit.Test

class TestWorkersSuccessDataToDomainMapper {

    @Test
    fun `test mapper`() {
        val workersSuccessDataToDomainMapper = WorkersSuccessDataToDomainMapper()

        val workersSuccessDataModel = WorkersDataModel.Success(
            "test", "test", "test", "test"
        )

        val actual = workersSuccessDataToDomainMapper.map(workersSuccessDataModel)
        val expected = WorkersEntity.SuccessEntity(
            "test", "test", "test", "test"
        )

        Assert.assertEquals(expected, actual)
    }
}