package data.datasource.workers.cache.realm.mappers

import com.example.kode.data.datasource.workers.cache.realm.mappers.LWorkerInfoDataModelToRealmMapper
import com.example.kode.data.datasource.workers.cache.realm.mappers.WorkerInfoDataModelToRealmMapper
import com.example.kode.data.datasource.workers.cache.realm.models.RealmWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import org.junit.Assert
import org.junit.Test

class TestLWorkerInfoDataModelToRealmMapper {

    @Test
    fun `test mapper`() {
        val mapper = WorkerInfoDataModelToRealmMapper()
        val listMapper = LWorkerInfoDataModelToRealmMapper(mapper)

        val testData = WorkersInfoStateDataModel.Cloud(
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