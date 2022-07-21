package data.repository.workers.mappers

import com.example.kode.data.repository.workers.mappers.WorkersSuccessDataToDomainMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test

class TestWorkersSuccessDataToDomainMapper {

    @Test
    fun `test mapper`() {
        val workersSuccessDataToDomainMapper = WorkersSuccessDataToDomainMapper()

        val workersSuccessDataModel = WorkerInfoDataModel.Success(
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            listOf("test"),
            "test"
        )

        val actual = workersSuccessDataToDomainMapper.map(workersSuccessDataModel)
        val expected = WorkersStateEntity.Success(
            "test", "test", "test", "test", "test"
        )

        Assert.assertEquals(expected, actual)
    }
}