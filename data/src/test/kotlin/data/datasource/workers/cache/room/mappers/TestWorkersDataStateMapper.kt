package data.datasource.workers.cache.room.mappers

import com.example.kode.data.datasource.workers.cache.room.mappers.`in`.WorkersDataStateMapper
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import com.example.kode.domain.core.Base
import org.junit.Assert
import org.junit.Test
import java.io.IOError
import java.io.IOException

class TestWorkersDataStateMapper {

    // Проверяется только определение модели.
    // Будет другой маппер и состояние, сделаю другой маппер чтобы их отличать

    @Test
    fun `test cloud workers state mapping`() {
        val mapper = WorkersDataStateMapper(TestCloudMapper())

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

        Assert.assertTrue(actual.isNotEmpty())
    }

    @Test(expected = IOException::class)
    fun `test no realization model in mapper mapping`() {
        val mapper = WorkersDataStateMapper(TestCloudMapper())
        val cloudWorkersModel = WorkersInfoStateDataModel.Cache(
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

        Assert.assertTrue(actual.isNotEmpty())
    }

    // TEST REALIZATION
    class TestCloudMapper : Base.Mapper<WorkersInfoStateDataModel.Cloud, MutableList<RoomWorkerModel>> {
        override fun map(model: WorkersInfoStateDataModel.Cloud): MutableList<RoomWorkerModel> = mutableListOf(
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
    }
}