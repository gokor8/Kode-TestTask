package data.repository.workers.mappers

import com.example.kode.data.repository.workers.mappers.WorkerInfoDataModelToDomainMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataCacheToEntityMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test

class TestWorkersStateDataCacheToDomainMapper {

    @Test
    fun `test mapping`() {
        val workerInfoDataModelToDomainMapper = WorkerInfoDataModelToDomainMapper()
        val mapper = WorkersStateDataCacheToEntityMapper(workerInfoDataModelToDomainMapper)

        val testData = WorkersInfoStateDataModel.Cache(
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

        val expected = WorkersStateEntity.NoConnection(
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

        val actual = testData.let(mapper::map)

        Assert.assertEquals(expected, actual)
    }
}