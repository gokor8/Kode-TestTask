package data.datasource.workers.cache.room.mappers

import com.example.kode.data.datasource.workers.cache.room.workers.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import org.junit.Assert
import org.junit.Test

class TestLRoomToWorkersCacheDataStateMapper {

    private val modelMapper = RoomWorkersModelToDataMapper()

    @Test
    fun `list to cache state mapping`() {
        val mapper = LRoomToWorkersCacheDataStateMapper(modelMapper)

        val listRoomWorkers = listOf(
            RoomWorkerModel(
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
        )

        val actual = listRoomWorkers.let(mapper::map)

        Assert.assertTrue(actual is List<WorkerInfoDataModel>)
    }
}