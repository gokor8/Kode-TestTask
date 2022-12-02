package domain.usecase.sort

import com.example.kode.domain.usecase.sort.StringStateSortUseCase
import domain.core.TestDomainState
import domain.core.sort.TestDomainSortStateFail
import domain.core.sort.TestDomainSortStateSuccess
import domain.core.sort.string.TestDomainStringSortStateSuccess
import domain.core.sort.string.TestExceptionDomainStringSortStateSuccess
import domain.core.sort.string.TestStringSortableModel
import domain.usecase.sort.mappers.TestFailMapper
import domain.usecase.sort.mappers.TestToNormalStateMapper
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TestSortDomainSortState {

    private val testSortState = TestDomainStringSortStateSuccess(
        listOf(
            TestStringSortableModel("test2"),
            TestStringSortableModel("test1"),
            TestStringSortableModel("bad2est"),
        )
    )

    @Test
    fun `test sort with full list return Success`(): Unit = runBlocking {
        val sortModel = testSortState
        val sortUseCase = StringStateSortUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestToNormalStateMapper()
        )

        val actual = sortUseCase.get(sortModel)

        val expected = TestDomainSortStateSuccess(
            listOf(
                TestStringSortableModel("bad2est"),
                TestStringSortableModel("test1"),
                TestStringSortableModel("test2"),
            )
        )

        TestCase.assertTrue(actual is TestDomainStringSortStateSuccess)
        actual as TestDomainStringSortStateSuccess
        TestCase.assertEquals(expected.getSortableList().size, actual.getSortableList().size)
        TestCase.assertEquals(expected.getSortableList(), actual.getSortableList())
    }

    @Test
    fun `test sort with return empty list return FailSort`(): Unit = runBlocking {
        val sortModel = TestDomainStringSortStateSuccess(listOf())
        val sortUseCase = StringStateSortUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestToNormalStateMapper()
        )

        val actual = sortUseCase.get(sortModel)

        TestCase.assertTrue(actual is TestDomainSortStateFail)
    }

    @Test()
    fun `test sort with something Exception`(): Unit = runBlocking {
        val sortModel = TestExceptionDomainStringSortStateSuccess(
            testSortState.getSortableList()
        )
        val sortUseCase = StringStateSortUseCase(
            this.coroutineContext,
            TestFailMapper(),
            TestToNormalStateMapper()
        )

        val actual = sortUseCase.get(sortModel)

        TestCase.assertTrue(actual is TestDomainState.Fail)

        actual as TestDomainState.Fail
        TestCase.assertTrue(actual.useCaseExceptions is TestFailSortException)
    }
}
