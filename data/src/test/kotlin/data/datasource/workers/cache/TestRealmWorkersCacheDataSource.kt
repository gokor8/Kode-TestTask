package com.example.kode.data.datasource.workers.cache

import com.example.kode.data.TestModel
import com.example.kode.domain.core.Base
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TestRealmWorkersCacheDataSource {

    private val cacheDataSource: WorkersCacheDataSource<TestModel> = RealmWorkersCacheDataSource(
        ,
        TestRealmModel::class.java,
        TestModelToRealmMapper(),
        TestRealmToModelMapper()
    )

    @Test
    fun `test save and get data`() = runBlocking {
        val expected = TestModel("test")

        cacheDataSource.save(expected)

        val actual = cacheDataSource.get()

        Assert.assertEquals(expected, actual)
    }


    // TEST REALIZATION
    open class TestRealmModel(
        @Required
        val name: String = ""
    ) : RealmObject()

    class TestModelToRealmMapper : Base.Mapper<TestModel, TestRealmModel> {
        override fun map(model: TestModel): TestRealmModel = TestRealmModel(model.name)
    }

    class TestRealmToModelMapper : Base.Mapper<TestRealmModel, TestModel> {
        override fun map(model: TestRealmModel): TestModel = TestModel(model.name)
    }
}