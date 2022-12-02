package domain.usecase.sort

import com.example.kode.domain.core.exceptions.UseCaseExceptions
import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.usecase.sort.StringSortableStateSortUseCase
import domain.core.TestDomainState
import domain.core.sort.TestDomainSortStateFail
import domain.core.sort.string.TestDomainStringSortStateSuccess
import domain.core.sort.string.TestExceptionDomainStringSortStateSuccess
import domain.core.sort.string.TestStringSortableModel
import domain.usecase.sort.mappers.TestFailMapper
import domain.usecase.sort.mappers.TestToNormalStateMapper
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TestSortByStringState {

    private val testSortState = TestDomainStringSortStateSuccess(
        listOf(
            TestStringSortableModel("test2"),
            TestStringSortableModel("test1"),
            TestStringSortableModel("bad2est"),
        )
    )

    @Test
    fun `test sort with Success sort`(): Unit = runBlocking {
        val sortModel = StringSortEntity("test", testSortState)
        val sortUseCase = StringSortableStateSortUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestToNormalStateMapper()
        )

        val actual = sortUseCase.get(sortModel)

        val expected = TestDomainStringSortStateSuccess(
            listOf(
                TestStringSortableModel("test2"),
                TestStringSortableModel("test1"),
            )
        )

        assertTrue(actual is TestDomainStringSortStateSuccess)

        val castedActual = actual as TestDomainStringSortStateSuccess
        assertEquals(castedActual.getSortableList().size, expected.getSortableList().size)
        assertEquals(castedActual.getSortableList(), expected.getSortableList())
    }

    @Test
    fun `test sort with FailSort`(): Unit = runBlocking {
        val sortModel = StringSortEntity("aboba", testSortState)
        val sortUseCase = StringSortableStateSortUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestToNormalStateMapper()
        )

        val actual = sortUseCase.get(sortModel)

        assertTrue(actual is TestDomainSortStateFail)
    }

    @Test
    fun `test sort with something Exception`(): Unit = runBlocking {
        val testData = TestExceptionDomainStringSortStateSuccess(
            testSortState.getSortableList()
        )

        val sortModel = StringSortEntity("aboba", testData)
        val sortUseCase = StringSortableStateSortUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestToNormalStateMapper()
        )

        val actual = sortUseCase.get(sortModel)

        assertTrue(actual is TestDomainState.Fail)

        actual as TestDomainState.Fail
        assertTrue(actual.useCaseExceptions is TestFailSortException)
    }
}