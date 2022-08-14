package data.repository.workers.mappers

import com.example.kode.data.repository.workers.mappers.WorkersStateDataToEntityMapper
import com.example.kode.data.repository.workers.mappers.WorkerInfoDataModelToDomainMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataSuccessToEntityMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test

class TestWorkersStateDataToEntityMapper {

    @Test
    fun `test success data model map`() {
        val workerInfoDataModelToDomainMapper = WorkerInfoDataModelToDomainMapper()
        val workersStateDataSuccessToEntityMapper =
            WorkersStateDataSuccessToEntityMapper(workerInfoDataModelToDomainMapper)
        val mapper =
            WorkersStateDataToEntityMapper(workersStateDataSuccessToEntityMapper)

        val testData = WorkersInfoStateDataModel.Success(
            mutableListOf(
                WorkerInfoDataModel(
                    "test",
                    "test",
                    "test",
                    "test",
                    "test",
                    "test",
                    "test",
                    listOf("test"),
                    "test",
                )
            )
        )

        val actual = testData.map(mapper)

        Assert.assertTrue(actual is WorkersStateEntity.Success)
    }
}