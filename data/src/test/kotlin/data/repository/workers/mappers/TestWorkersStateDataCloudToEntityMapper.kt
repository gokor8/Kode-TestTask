package data.repository.workers.mappers

import com.example.kode.data.repository.workers.mappers.WorkerInfoDataModelToDomainMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataCloudToEntityMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataToEntityMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test

class TestWorkersStateDataCloudToEntityMapper {

    @Test
    fun `test mapping`() {
        val infoMapper = WorkerInfoDataModelToDomainMapper()
        val mapper = WorkersStateDataCloudToEntityMapper(infoMapper)

        val testData = WorkersInfoStateDataModel.Cloud(
            mutableListOf(
                WorkerInfoDataModel(
                    "id",
                    "avatar",
                    "name",
                    "lastName",
                    "userTag",
                    "department",
                    "position",
                    listOf("birthday"),
                    "phone"
                )
            )
        )

        val actual = testData.let(mapper::map)
        val expected = WorkersStateEntity.Success(
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

        Assert.assertEquals(expected, actual)
    }
}