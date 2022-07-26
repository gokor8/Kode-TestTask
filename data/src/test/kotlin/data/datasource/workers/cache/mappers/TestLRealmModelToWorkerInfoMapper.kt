package data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.mappers.LRealmModelToWorkerInfoMapper
import com.example.kode.data.datasource.workers.cache.mappers.RealmModelToWorkerInfoMapper
import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert
import org.junit.Test

class TestLRealmModelToWorkerInfoMapper {

    @Test
    fun `test list mapping`() {
        val mapper = RealmModelToWorkerInfoMapper()
        val listMapper = LRealmModelToWorkerInfoMapper(mapper)

        val testData = listOf(
            RealmWorkerModel(
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
            RealmWorkerModel(
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

        val actual = listMapper.map(testData)
        val expected = listOf(
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

        Assert.assertEquals(expected, actual)
    }
}