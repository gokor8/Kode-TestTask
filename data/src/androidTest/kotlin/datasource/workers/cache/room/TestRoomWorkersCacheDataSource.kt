package datasource.workers.cache.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.kode.data.datasource.core.cache.AppDatabase
import com.example.kode.data.datasource.workers.cache.exceptions.NoCacheException
import com.example.kode.data.datasource.workers.cache.room.RoomWorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.domain.core.Base
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TestRoomWorkersCacheDataSource {

    private val testInMapper = TestInMapper()
    private val testOutMapper = TestOutMapper()

    private lateinit var database: AppDatabase
    private lateinit var roomCacheDataSource: RoomWorkersCacheDataSource<TestModel>

    private val testModel = TestModel(List(2) {
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
    })

    @Before
    fun setupBefore() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        roomCacheDataSource = RoomWorkersCacheDataSource(database.workersDao(), testInMapper, testOutMapper)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @Test
    fun test_save_and_get_list_data(): Unit = runBlocking {
        roomCacheDataSource.save(testModel)
        val expected = roomCacheDataSource.get()

        Assert.assertTrue(expected.workers.size == 2)
    }

    @Test(expected = NoCacheException::class)
    fun test_get_empty_list_data(): Unit = runBlocking {
        val expected = roomCacheDataSource.get()

        Assert.assertTrue(expected.workers.isEmpty())
    }


    // TEST REALIZATION
    data class TestModel(
        val workers: List<RoomWorkerModel>
    ) : Base.IgnorantMapper<TestModel> {
        override fun <I : Base.Mapper<TestModel, R>, R> map(model: I): R = model.map(this)
    }

    class TestInMapper : Base.Mapper<TestModel, List<RoomWorkerModel>> {
        override fun map(model: TestModel): List<RoomWorkerModel> = model.workers
    }

    class TestOutMapper : Base.Mapper<List<RoomWorkerModel>, TestModel> {
        override fun map(model: List<RoomWorkerModel>) = TestModel(model)
    }
}