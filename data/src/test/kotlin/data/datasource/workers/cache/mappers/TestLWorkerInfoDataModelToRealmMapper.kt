package data.datasource.workers.cache.mappers

import com.example.kode.data.datasource.workers.cache.mappers.LWorkerInfoDataModelToRealmMapper
import com.example.kode.data.datasource.workers.cache.mappers.WorkerInfoDataModelToRealmMapper
import com.example.kode.data.datasource.workers.cache.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert
import org.junit.Test

class TestLWorkerInfoDataModelToRealmMapper {

    @Test
    fun `test mapper`() {
        val mapper = WorkerInfoDataModelToRealmMapper()
        val listMapper = LWorkerInfoDataModelToRealmMapper(mapper)

        val testData = listOf(
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

        val actual = listMapper.map(testData)
        val expected = listOf(
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

        Assert.assertEquals(expected, actual)
    }
}