package data.datasource.workers.cache.room.mappers

import com.example.kode.data.datasource.workers.cache.room.mappers.out.LRoomToWorkersCacheDataStateMapper
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import org.junit.Assert
import org.junit.Test

class TestLRoomToWorkersCacheDataStateMapper {

    private val modelMapper = TestRoomModelToDataMapper()

    @Test
    fun `list to cache state mapping`() {
        val mapper = LRoomToWorkersCacheDataStateMapper(modelMapper)

        val listRoomWorkers = MutableList(2) {
            RoomWorkerModel(
                id = "id$it",
                avatarUrl = "avatar",
                name = "name",
                lastName = "lastName",
                userTag = "userTag",
                department = "department",
                position = "position",
                birthday = "birthday",
                phone = "phone"
            )
        }

        val actual = listRoomWorkers.let(mapper::map)

        val expected = WorkersInfoStateDataModel.Cache(
            List(2) {
                WorkerInfoDataModel(
                    "id$it",
                    "avatar",
                    "name",
                    "lastName",
                    "userTag",
                    "department",
                    "position",
                    listOf("birthday"),
                    "phone"
                )
            }
        )

        Assert.assertEquals(actual, expected)
    }


    // TEST REALIZATIONS
    inner class TestRoomModelToDataMapper : Base.Mapper<RoomWorkerModel, WorkerInfoDataModel> {
        override fun map(model: RoomWorkerModel) = generateModel(model.id ?: "")

        private fun generateModel(inputId: String) = WorkerInfoDataModel(
            id = inputId,
            avatarUrl = "avatar",
            firstName = "name",
            lastName = "lastName",
            userTag = "userTag",
            department = "department",
            position = "position",
            birthday = listOf("birthday"),
            phone = "phone"
        )

    }
}