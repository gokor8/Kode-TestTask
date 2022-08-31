package data.datasource.workers.cache.room.mappers

import com.example.kode.data.repository.workers.models.WorkerInfoDataModel
import com.example.kode.data.repository.workers.models.WorkersInfoStateDataModel
import org.junit.Assert
import org.junit.Test

class TestWorkersCloudDataStateToLRoomMapper {

    @Test
    fun `test cloud state model to list mapping`() {
        val mapper = WorkersDataStateMapper(fakeCloudMapper)

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

        Assert.assertTrue(actual is WorkersInfoStateDataModel.Cloud)
    }
}