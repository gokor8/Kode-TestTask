package com.example.kode.data.datasource.workers.cache

import com.example.kode.data.TestModel
import org.junit.Assert
import org.junit.Test

class TestWorkersCacheDataSource {

    private lateinit var cacheDataSource: WorkersCacheDataSource<TestModel, TestModel>

    @Test
    fun `test save and get data`() {
        val expected = TestModel("test")

        cacheDataSource.save(expected)

        val actual = cacheDataSource.get()

        Assert.assertEquals(expected, actual)
    }
}