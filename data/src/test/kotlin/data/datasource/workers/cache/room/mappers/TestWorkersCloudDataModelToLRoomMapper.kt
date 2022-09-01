package data.datasource.workers.cache.room.mappers

import com.example.kode.data.datasource.workers.cache.room.mappers.`in`.WorkersCloudDataModelToLRoomMapper
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import org.junit.Assert
import org.junit.Test

class TestWorkersCloudDataModelToLRoomMapper {

    private val testMapper = TestCloudDataModelMapper()

    // Если есть какая-то сортировка можно это проверить

    @Test
    fun `test cloud state model to list mapping`() {
        val mapper = WorkersCloudDataModelToLRoomMapper(testMapper)

        val cloudWorkersModel = WorkersInfoStateDataModel.Cloud(
            MutableList(2) {
                WorkerInfoDataModel(
                    "id$it",
                "avatar",
                "name",
                "lastName",
                "userTag",
                "department",
                "position",
                listOf("birthday"),
                "phone")
            }
        )

        val actual = cloudWorkersModel.let(mapper::map)

        val expected = List(2) {
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

        Assert.assertEquals(expected, actual)
    }


    // TEST REALIZATIONS
    inner class TestCloudDataModelMapper : Base.Mapper<WorkerInfoDataModel, RoomWorkerModel> {
        override fun map(model: WorkerInfoDataModel) = generateModel(model.id)

        private fun generateModel(inputId: String) = RoomWorkerModel(
            id = inputId,
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
}