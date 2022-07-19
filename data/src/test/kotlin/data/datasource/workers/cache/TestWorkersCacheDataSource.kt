package com.example.kode.data.datasource.workers.cache

import com.example.kode.data.TestModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestWorkersCacheDataSource {

    private lateinit var cacheDataSource: WorkersCacheDataSource<TestModel>
       // RealmWorkersCacheDataSource()

    @Test
    fun `test save and get data`() = runBlocking {
        val expected = TestModel("test")

        cacheDataSource.save(expected)

        val actual = cacheDataSource.get()

        Assert.assertEquals(expected, actual)
    }
}