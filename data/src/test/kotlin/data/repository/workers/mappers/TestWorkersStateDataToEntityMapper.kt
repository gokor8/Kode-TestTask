package data.repository.workers.mappers

import com.example.kode.data.repository.workers.mappers.WorkersStateDataToEntityMapper
import com.example.kode.data.repository.workers.mappers.WorkersSuccessDataToDomainMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test

class TestWorkersStateDataToEntityMapper {

    @Test
    fun `test success data model map`() {
        val workersSuccessDataToDomainMapper = WorkersSuccessDataToDomainMapper()
        val workersStateDataToEntityMapper =
            WorkersStateDataToEntityMapper(workersSuccessDataToDomainMapper)

        val workerInfoDataModel = WorkerInfoDataModel.Success(
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

        val actual = workersStateDataToEntityMapper.map(workerInfoDataModel)
        val expected = WorkersStateEntity.Success(
            "test",
            "test",
            "test",
            "test",
            "test"
        )

        Assert.assertEquals(expected, actual)
    }
}