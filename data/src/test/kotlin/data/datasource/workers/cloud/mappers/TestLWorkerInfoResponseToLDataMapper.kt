package data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.mappers.LWorkerInfoResponseToLDataMapper
import com.example.kode.data.datasource.workers.cloud.mappers.WorkerInfoResponseToDataMapper
import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert
import org.junit.Test

class TestLWorkerInfoResponseToLDataMapper {

    @Test
    fun `test mapping`() {
        val mapper = WorkerInfoResponseToDataMapper()
        val listMapper = LWorkerInfoResponseToLDataMapper(mapper)

        val testData = listOf(
            WorkerInfoResponse(
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
            WorkerInfoResponse(
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

        val actual = listMapper.map(testData)
        val expected = listOf(
            WorkerInfoDataModel.Success(
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
            WorkerInfoDataModel.Success(
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

        Assert.assertEquals(expected, actual)
    }
}