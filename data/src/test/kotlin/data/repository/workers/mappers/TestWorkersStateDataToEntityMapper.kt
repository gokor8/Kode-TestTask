package data.repository.workers.mappers

import com.example.kode.data.repository.workers.mappers.WorkerInfoDataModelToDomainMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataCacheToEntityMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataCloudToEntityMapper
import com.example.kode.data.repository.workers.mappers.WorkersStateDataToEntityMapper
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.entity.workers.WorkerInfoEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test

class TestWorkersStateDataToEntityMapper {

    private val workerInfoDataModelToDomainMapper = WorkerInfoDataModelToDomainMapper()

    private val workersStateDataCloudToEntityMapper =
        WorkersStateDataCloudToEntityMapper(workerInfoDataModelToDomainMapper)

    private val workersStateDataCacheToEntityMapper =
        WorkersStateDataCacheToEntityMapper(workerInfoDataModelToDomainMapper)

    @Test
    fun `test cloud data model map to success`() {
        val mapper =
            WorkersStateDataToEntityMapper(
                workersStateDataCloudToEntityMapper,
                workersStateDataCacheToEntityMapper
            )

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
        val actual = testData.map(mapper)

        Assert.assertEquals(expected, actual)
    }

    @Test
    fun `test cache data model map to no connection`() {
        val mapper =
            WorkersStateDataToEntityMapper(
                workersStateDataCloudToEntityMapper,
                workersStateDataCacheToEntityMapper
            )

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
        val actual = testData.map(mapper)

        Assert.assertEquals(expected, actual)
    }
}