package data.datasource.workers.cache.room.mappers

import com.example.kode.data.datasource.workers.cache.room.mappers.`in`.WorkerInfoDataModelToRoomMapper
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert
import org.junit.Test

class TestWorkerInfoDataModelToRoomMapper {

    @Test
    fun `test mapping`() {
        val mapper = WorkerInfoDataModelToRoomMapper()

        val workerInfoDataModel = WorkerInfoDataModel(
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

        val actual = workerInfoDataModel.map(mapper)

        val expected = RoomWorkerModel(
            id = "id",
            avatarUrl = "avatar",
            name = "name",
            lastName = "lastName",
            userTag = "userTag",
            department = "department",
            position = "position",
            birthday = "birthday",
            phone = "phone"
        )

        Assert.assertEquals(expected, actual)
    }
}