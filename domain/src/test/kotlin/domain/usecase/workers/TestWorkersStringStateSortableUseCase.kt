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
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class TestWorkersStringStateSortableUseCase {

    lateinit var sortableUseCase: StringStateSortableUseCase<WorkersNameSortableStateEntity,
            WorkerNameSortableEntity, WorkersStateEntity>

    @Before
    fun before() = runBlocking {
        sortableUseCase = StringStateSortableUseCase(
            this.coroutineContext,
            TestFailMapper(),
            WorkersNameSortableStateToWorkersState(ListWorkerNameSortableToListWorkerInfo())
        )
    }

    @Test
    fun `test sort with full list return sorted Success`() = runBlocking {
        val testData = WorkersNameSortableStateEntity(
            listOf(
                WorkerNameSortableEntity(
                    "id1",
                    "avatarUrl1",
                    "name1",
                    "lastName1",
                    "userTag1",
                    "position1",
                ),
                WorkerNameSortableEntity(
                    "id",
                    "avatarUrl",
                    "name",
                    "lastName",
                    "userTag",
                    "position",
                )
            )
        )

        val state = sortableUseCase.get(testData)

        val expectedList = testData.getSortableList().reversed()

        assertTrue(state is WorkersStateEntity.WithConnection)
        state as WorkersStateEntity.WithConnection

        assertEquals(expectedList, state.workers)
    }


    // TEST REALIZATIONS

    class TestFailMapper : Base.Mapper<Exception, WorkersStateEntity> {
        override fun map(model: Exception): WorkersStateEntity =
            WorkersStateEntity.Fail(UseCaseExceptions.GenericException)
    }
}