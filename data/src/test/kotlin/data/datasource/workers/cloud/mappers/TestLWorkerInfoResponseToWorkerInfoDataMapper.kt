package data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.mappers.WorkerInfoResponseToDataMapper
import com.example.kode.data.datasource.workers.cloud.mappers.WorkersResponseToDataMapperImpl
import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.datasource.workers.cloud.models.WorkersResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.entity.workers.WorkersStateEntity
import org.junit.Assert
import org.junit.Test

class TestLWorkerInfoResponseToWorkerInfoDataMapper {

    @Test
    fun `test mapping`() {
        val mapper = WorkerInfoResponseToDataMapper()
        val listMapper = WorkersResponseToDataMapperImpl(mapper)

        val testData = WorkersResponse(
            listOf(
                WorkerInfoResponse(
                    "test",
                    "test",
                    "test",
                    "test",
                    "test",
                    "test",
                    "test",
                    "test",
                    "test"
                ),
                WorkerInfoResponse(
                    "test1",
                    "test1",
                    "test1",
                    "test1",
                    "test1",
                    "test1",
                    "test1",
                    "test1",
                    "test1"
                )
            )
        )

        val actual = listMapper.map(testData)
        val expected = WorkersInfoStateDataModel.Success(
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
                    "test"
                ),
                WorkerInfoDataModel(
                    "test1",
                    "test1",
                    "test1",
                    "test1",
                    "test1",
                    "test1",
                    "test1",
                    listOf("test1"),
                    "test1"
                )
            )
        )

        Assert.assertEquals(expected, actual)
    }
}