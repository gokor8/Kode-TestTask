package domain.usecase.workers

import com.example.kode.domain.core.Base
import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.entity.workers.WorkerNameSortableEntity
import com.example.kode.domain.entity.workers.WorkersNameSortableStateEntity
import com.example.kode.domain.entity.workers.WorkersStateEntity
import com.example.kode.domain.usecase.sort.StringStateSortableUseCase
import com.example.kode.domain.usecase.workers.mappers.ListWorkerNameSortableToListWorkerInfo
import com.example.kode.domain.usecase.workers.mappers.WorkersNameSortableStateToWorkersState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.io.IOException

class TestWorkersStringStateSortableUseCase {

    private val sortableWorkersToWorkersInfo = ListWorkerNameSortableToListWorkerInfo()

    private val testDataStore = TestWorkersDataStore()

    lateinit var sortableUseCase: StringStateSortableUseCase<WorkersNameSortableStateEntity,
            WorkerNameSortableEntity, WorkersStateEntity>

    private fun CoroutineScope.setupUseCase() = StringStateSortableUseCase(
        this.coroutineContext,
        TestFailMapper(),
        WorkersNameSortableStateToWorkersState(sortableWorkersToWorkersInfo)
    )

    @Test
    fun `test with reversed list return sorted list`(): Unit = runBlocking {
        sortableUseCase = setupUseCase()

        // c c, b b, a a
        val testData = WorkersNameSortableStateEntity(testDataStore.testData)

        val state = sortableUseCase.get(testData)


        assertTrue(state is WorkersStateEntity.WithConnection)
        state as WorkersStateEntity.WithConnection

        val expected = sortableWorkersToWorkersInfo.map(testData.getSortableList().reversed())
        val actual = state.workers

        assertEquals(expected, actual)
    }

    @Test
    fun `test with empty list return sorted list`(): Unit = runBlocking {
        sortableUseCase = setupUseCase()

        val testData = WorkersNameSortableStateEntity(emptyList())

        val state = sortableUseCase.get(testData)


        assertTrue(state is WorkersStateEntity.WithConnection)
        state as WorkersStateEntity.WithConnection

        val expected = sortableWorkersToWorkersInfo.map(emptyList())
        val actual = state.workers

        assertEquals(expected, actual)
    }

    @Test
    fun `test with sorted list return list without changes`(): Unit = runBlocking {
        sortableUseCase = setupUseCase()

        val testData = WorkersNameSortableStateEntity(testDataStore.testData.reversed())

        val state = sortableUseCase.get(testData)


        assertTrue(state is WorkersStateEntity.WithConnection)
        state as WorkersStateEntity.WithConnection

        val expected = sortableWorkersToWorkersInfo.map(testData.getSortableList())
        val actual = state.workers

        assertEquals(expected, actual)
    }

    @Test
    fun `test with exception mapper return fail model`(): Unit = runBlocking {
        sortableUseCase = StringStateSortableUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestExceptionToStateMapper()
        )

        val testData = WorkersNameSortableStateEntity(testDataStore.testData.reversed())

        val state = sortableUseCase.get(testData)


        assertTrue(state is WorkersStateEntity.Fail)
        state as WorkersStateEntity.Fail

        val expected = UseCaseExceptions.GenericException
        val actual = state.exception

        assertEquals(expected, actual)
    }


    // TEST REALIZATIONS

    class TestFailMapper : Base.Mapper<Exception, WorkersStateEntity> {
        override fun map(model: Exception): WorkersStateEntity =
            WorkersStateEntity.Fail(UseCaseExceptions.GenericException)
    }

    class TestExceptionToStateMapper :
        Base.Mapper<WorkersNameSortableStateEntity, WorkersStateEntity> {

        override fun map(model: WorkersNameSortableStateEntity): WorkersStateEntity {
            throw IOException("Test exception")
        }
    }

    // Local realization, if it need in many places. TODO it global and move to core test package
    interface TestDataStore<M> {
        val testData: M
    }

    class TestWorkersDataStore : TestDataStore<List<WorkerNameSortableEntity>> {

        override val testData = listOf(
            WorkerNameSortableEntity(
                "id",
                "avatarUrl",
                "c",
                "c",
                "userTag",
                "position",
            ),
            WorkerNameSortableEntity(
                "id",
                "avatarUrl",
                "b",
                "b",
                "userTag",
                "position",
            ),
            WorkerNameSortableEntity(
                "id1",
                "avatarUrl1",
                "a",
                "a",
                "userTag1",
                "position1",
            )
        )
    }
}