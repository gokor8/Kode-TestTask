package data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.mappers.LWorkerInfoResponseToLDataMapper
import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert
import org.junit.Test

class TestWorkerInfoResponseToDataMapper {

    @Test
    fun `test mapping`() {
        val mapper = LWorkerInfoResponseToLDataMapper()
        val testData = WorkerInfoResponse(
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            listOf("test"),
            "test")

        val actual = testData.map(mapper)
        val expected = WorkerInfoDataModel.Success(
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

        Assert.assertEquals(expected, actual)
    }
}