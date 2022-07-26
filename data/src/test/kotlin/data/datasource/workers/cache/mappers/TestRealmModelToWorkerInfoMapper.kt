package data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.mappers.RealmModelToWorkerInfoMapper
import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert
import org.junit.Test

class TestRealmModelToWorkerInfoMapper {

    @Test
    fun `test mapping`() {
        val mapper = RealmModelToWorkerInfoMapper()

        val testData = RealmWorkerModel(
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

        val actual = mapper.map(testData)
        val expected = WorkerInfoDataModel(
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