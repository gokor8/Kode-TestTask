package domain.usecase.sort

import com.example.kode.domain.entity.sort.by_string.StringSortEntity
import com.example.kode.domain.usecase.sort.StringStateSortUseCase
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

class TestStringStateSortUseCase {

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
        val sortUseCase = StringStateSortUseCase(
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

        actual as TestDomainStringSortStateSuccess

        assertEquals(actual.getSortableList().size, expected.getSortableList().size)
        assertEquals(actual.getSortableList(), expected.getSortableList())
    }

    @Test
    fun `test sort with FailSort`(): Unit = runBlocking {
        val sortModel = StringSortEntity("aboba", testSortState)
        val sortUseCase = StringStateSortUseCase(
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
        val sortUseCase = StringStateSortUseCase(
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