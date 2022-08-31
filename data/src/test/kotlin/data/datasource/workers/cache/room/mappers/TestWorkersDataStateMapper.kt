package data.datasource.workers.cache.room.mappers

import com.example.kode.data.datasource.workers.cache.room.workers.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import org.junit.Assert
import org.junit.Test

class TestWorkersDataStateMapper {

    val cloudMapper = WorkersCloudDataStateToLRoomMapper()

    @Test
    fun `test cloud workers state mapping`() {
        val mapper = WorkersDataStateMapper(cloudMapper)
        val cloudWorkersModel = WorkersInfoStateDataModel.Cloud(
            mutableListOf(
                WorkerInfoDataModel(
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
            )
        )

        val actual = cloudWorkersModel.map(mapper)

        val expected = listOf(
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

        Assert.assertEquals(expected, actual)
    }
}