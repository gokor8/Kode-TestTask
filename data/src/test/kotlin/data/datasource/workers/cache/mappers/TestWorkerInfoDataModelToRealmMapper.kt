package data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.mappers.WorkerInfoDataModelToRealmMapper
import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert
import org.junit.Test

class TestWorkerInfoDataModelToRealmMapper {

    @Test
    fun `test mapping`() {
        val mapper = WorkerInfoDataModelToRealmMapper()

        val testData = WorkerInfoDataModel(
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

        val actual = mapper.map(testData)
        val expected = RealmWorkerModel(
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test",
            "test"
        )

        Assert.assertEquals(expected, actual)
    }

}