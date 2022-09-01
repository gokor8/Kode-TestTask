package data.datasource.workers.cache.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.kode.data.datasource.core.cache.AppDatabase
import com.example.kode.data.datasource.workers.cache.room.RoomWorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.room.WorkersDao
import com.example.kode.data.datasource.workers.cache.room.models.RoomWorkerModel
import com.example.kode.domain.core.Base
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

class TestRoomWorkersCacheDataSource {

    private val testInMapper = TestInMapper()
    private val testOutMapper = TestOutMapper()
    private val roomCacheDataSource =
        RoomWorkersCacheDataSource(workersDao, testInMapper, testOutMapper)
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
    lateinit var workersDao: WorkersDao

    @Before
    fun setupBefore() {
        // Может сделать тут даггер, и тествоый subModule?
        val context = ApplicationProvider.getApplicationContext<Context>()
        val dataBase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        workersDao = dataBase.workersDao()
    }

    @Test
    suspend fun `test save and get list data`(): Unit = runBlocking {
        roomCacheDataSource.save(testModel)
        val expected = roomCacheDataSource.get()

        Assert.assertTrue(expected.workers.size == 2)
    }

    @Test// Ожидать ошибку
    suspend fun `test get empty list data`(): Unit = runBlocking {
        // Пока непонятно, как оно работает, будет ли само выбрасывать ошибку?
        // Если да, то ловим её в репозитории и выкидываем нашу NoCache
        // Если нет, сразу нашу кидаем
        val expected = roomCacheDataSource.get()

        Assert.assertTrue(expected.workers.size == 2)
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