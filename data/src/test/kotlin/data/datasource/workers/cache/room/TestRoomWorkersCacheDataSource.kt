package data.datasource.workers.cache.room

import org.junit.Assert
import org.junit.Test

class TestRoomWorkersCacheDataSource {

    @Test
    fun `test save and get data`() {
        val roomCacheDataSource = RoomWorkersCacheDataSource(testMapper)

        roomCacheDataSource.save(testData)
        val expected = roomCacheDataSource.get()

        Assert.assertTrue(expected.size == 2)
    }

    @Test// Ожидать ошибку
    fun `test get empty data`() {
        // Пока непонятно, как оно работает, будет ли само выбрасывать ошибку?
        // Если да, то ловим её в репозитории и выкидываем нашу NoCache
        // Если нет, сразу нашу кидаем
        val roomCacheDataSource = RoomWorkersCacheDataSource(testMapper)

        val expected = roomCacheDataSource.get()

        Assert.assertTrue(expected.size == 2)
    }
}