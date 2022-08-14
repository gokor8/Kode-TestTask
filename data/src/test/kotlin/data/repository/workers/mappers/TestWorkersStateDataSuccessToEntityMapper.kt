package data.repository.workers.mappers

import com.example.kode.data.repository.workers.mappers.WorkerInfoDataModelToDomainMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataSuccessToEntityMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataToEntityMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test

class TestWorkersStateDataSuccessToEntityMapper {

    @Test
    fun `test mapping`() {
        val infoMapper = WorkerInfoDataModelToDomainMapper()
        val successMapper = WorkersStateDataSuccessToEntityMapper(infoMapper)
        val mapper = WorkersStateDataToEntityMapper(successMapper)

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
        val expected = WorkersStateEntity.Success(
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

        Assert.assertEquals(expected, actual)
    }
}