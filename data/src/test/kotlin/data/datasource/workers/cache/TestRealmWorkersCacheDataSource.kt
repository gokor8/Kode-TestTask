package data.datasource.workers.cache

import android.app.Application
import android.content.Context
import com.example.kode.data.datasource.workers.cache.RealmWorkersCacheDataSource
import com.example.kode.data.datasource.workers.cache.WorkersCacheDataSource
import com.example.kode.domain.core.Base
import data.core.TestModel
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.Required
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@Deprecated("Cant testing")
class TestRealmWorkersCacheDataSource {

    private lateinit var cacheDataSource: WorkersCacheDataSource<TestModel>

    @Before
    fun setup() {
        /*val realmTestConfiguration: RealmConfiguration = RealmConfiguration.Builder()
            .inMemory()
            .name("test-realm")
            .build()*/

        cacheDataSource =  RealmWorkersCacheDataSource(
            Realm.getDefaultInstance(),
            TestRealmModel::class.java,
            TestModelToRealmMapper(),
            TestRealmToModelMapper()
        )
    }

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

    class TestModelToRealmMapper : Base.Mapper<TestModel, List<TestRealmModel>> {
        override fun map(model: TestModel): List<TestRealmModel> =
            listOf(TestRealmModel(model.name))
    }

    class TestRealmToModelMapper : Base.Mapper<List<TestRealmModel>, TestModel> {
        override fun map(model: List<TestRealmModel>): TestModel =
            TestModel(model[0].name)
    }
}