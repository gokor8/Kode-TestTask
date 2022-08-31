package data.datasource.workers.cache.room.mappers

import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert

class TestRoomWorkersModelToDataMapper {

    fun `test mapping`() {
        val mapper = RoomWorkersModelToDataMapper()

        val roomWorkerModel = RoomWorkerModel(
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

        val actual = roomWorkerModel.let(mapper::map)

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