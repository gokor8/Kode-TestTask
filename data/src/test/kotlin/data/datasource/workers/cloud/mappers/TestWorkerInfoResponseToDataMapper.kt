package data.datasource.workers.cloud.mappers

import com.example.kode.data.datasource.workers.cloud.mappers.WorkerInfoResponseToDataMapper
import com.example.kode.data.datasource.workers.cloud.models.WorkerInfoResponse
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert
import org.junit.Test

class TestWorkerInfoResponseToDataMapper {

    @Test
    fun `test mapping`() {
        val mapper = WorkerInfoResponseToDataMapper()
        val testData = WorkerInfoResponse(
            "id",
            "avatar",
            "name",
            "lastName",
            "userTag",
            "department",
            "position",
            "birthday",
            "phone"
        )

        val actual = testData.map(mapper)
        val expected = WorkerInfoDataModel(
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

        Assert.assertEquals(expected, actual)
    }
}