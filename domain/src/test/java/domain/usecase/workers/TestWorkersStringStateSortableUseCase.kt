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
import org.junit.Before
import org.junit.Test

class TestWorkersStringStateSortableUseCase {

    private val sortableWorkersToWorkersInfo = ListWorkerNameSortableToListWorkerInfo()

    lateinit var sortableUseCase: StringStateSortableUseCase<WorkersNameSortableStateEntity,
            WorkerNameSortableEntity, WorkersStateEntity>

    @Test
    fun `test with full list return sorted Success`(): Unit = runBlocking {
        sortableUseCase = StringStateSortableUseCase(
            this.coroutineContext,
            TestFailMapper(),
            WorkersNameSortableStateToWorkersState(sortableWorkersToWorkersInfo)
        )

        val testData = WorkersNameSortableStateEntity(
            listOf(
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
        )

        val state = sortableUseCase.get(testData)

        val expectedList = testData.getSortableList().reversed()

        assertTrue(state is WorkersStateEntity.WithConnection)
        state as WorkersStateEntity.WithConnection

        assertEquals(sortableWorkersToWorkersInfo.map(expectedList), state.workers)
    }

    @Test
    fun `test with sorted list return list without changes`(): Unit = runBlocking {
        sortableUseCase = StringStateSortableUseCase(
            this.coroutineContext,
            TestFailMapper(),
            WorkersNameSortableStateToWorkersState(sortableWorkersToWorkersInfo)
        )

        val testData = WorkersNameSortableStateEntity(
            listOf(
                WorkerNameSortableEntity(
                    "id1",
                    "avatarUrl1",
                    "a",
                    "a",
                    "userTag1",
                    "position1",
                ),
                WorkerNameSortableEntity(
                    "id",
                    "avatarUrl",
                    "b",
                    "b",
                    "userTag",
                    "position",
                )
            )
        )

        val state = sortableUseCase.get(testData)

        val expectedList = testData.getSortableList()

        assertTrue(state is WorkersStateEntity.WithConnection)
        state as WorkersStateEntity.WithConnection

        assertEquals(sortableWorkersToWorkersInfo.map(expectedList), state.workers)
    }

    // TEST REALIZATIONS

    class TestFailMapper : Base.Mapper<Exception, WorkersStateEntity> {
        override fun map(model: Exception): WorkersStateEntity =
            WorkersStateEntity.Fail(UseCaseExceptions.GenericException)
    }
}